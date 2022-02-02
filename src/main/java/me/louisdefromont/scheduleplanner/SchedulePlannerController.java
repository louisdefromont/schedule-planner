package me.louisdefromont.scheduleplanner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class SchedulePlannerController {
    @Autowired
    private ScheduleDateRepository scheduleDateRepository;

    @Autowired
    private ScheduledEventRepository scheduledEventRepository;

    @Autowired
    private PlannedEventRepository plannedEventRepository;

    @Autowired
    private RepeatableEventRepository repeatableEventRepository;

    @Autowired
    private ToDoEventRepository toDoEventRepository;

    @PostMapping(path = "/generate/{days}")
    public List<ScheduleDate> generateSchedule(@PathVariable int days) {
        scheduleDateRepository.deleteAll();
        List<ScheduleDate> scheduleDates = new ArrayList<>();
        for (int day = 0; day < days; day++) {
            ScheduleDate scheduleDate = generateDate(day);
            // scheduleDateRepository.save(scheduleDate);
            scheduleDates.add(scheduleDate);
        }
        return scheduleDates;
    }

    private ScheduleDate generateDate(int day) {
        ScheduleDate scheduleDate = new ScheduleDate();
        scheduleDate.setId(day);
        scheduleDate.setDate(LocalDate.now().plusDays(day));
        scheduleDate.setEvents(generateEvents(scheduleDate.getDate()));
        return scheduleDate;
    }

    private List<ScheduledEvent> generateEvents(LocalDate date) {
        List<ScheduledEvent> events = new ArrayList<ScheduledEvent>();
        plannedEventRepository.findAll().forEach(plannedEvent -> {
            if (plannedEvent.getDate().equals(date)) {
                ScheduledEvent scheduledEvent = new ScheduledEvent();
                scheduledEvent.setName(plannedEvent.getName());
                scheduledEvent.setStartTime(plannedEvent.getStartTime());
                scheduledEvent.setEndTime(plannedEvent.getEndTime());
                events.add(scheduledEvent);
            }
        });
        repeatableEventRepository.findAll().forEach(repeatableEvent -> {
            if (repeatableEvent.getStartDate().until(date, ChronoUnit.DAYS) % repeatableEvent.getRepeatInterval() == 0) {
                ScheduledEvent scheduledEvent = new ScheduledEvent();
                scheduledEvent.setName(repeatableEvent.getName());
                scheduledEvent.setStartTime(repeatableEvent.getStartTime());
                scheduledEvent.setEndTime(repeatableEvent.getEndTime());
                events.add(scheduledEvent);
            }
        });
        return events;
    }
}
