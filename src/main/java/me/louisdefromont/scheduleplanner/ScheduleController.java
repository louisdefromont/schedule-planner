package me.louisdefromont.scheduleplanner;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.louisdefromont.Event;
import me.louisdefromont.PlannedEvent;
import me.louisdefromont.RepeatableEvent;
import me.louisdefromont.Schedule;
import me.louisdefromont.ToDoEvent;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleRepository scheduleRepository;

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

    @PostMapping(path = "/generate")
    public Schedule generateSchedule() {
        LocalDate generateUntil = LocalDate.now().plusDays(5);
        Optional<ToDoEvent> lastToDoEvent = toDoEventRepository.findTopByOrderByDueDateTimeDesc();
        // if (lastToDoEvent.isPresent()) {
        //     generateUntil = lastToDoEvent.get().getDueDateTime().toLocalDate();
        // }
        Schedule schedule = new Schedule(generateUntil, plannedEventRepository.findAll(), repeatableEventRepository.findAll(), toDoEventRepository.findAll());
        scheduleRepository.save(schedule);
        return schedule;
    }

    @PostMapping(path = "/addDummyData")
    public void addDummyData() {
        ToDoEvent toDoEvent = new ToDoEvent();
        toDoEvent.setName("Dummy Event");
        toDoEvent.setDueDateTime(LocalDate.now().plusDays(1).atStartOfDay());
        toDoEvent.setEstimatedMinutes(30);
        toDoEventRepository.save(toDoEvent);

        PlannedEvent plannedEvent = new PlannedEvent();
        plannedEvent.setName("Dummy Event 2");
        plannedEvent.setStartDateTime(LocalDate.now().plusDays(1).atStartOfDay());
        plannedEvent.setEndDateTime(LocalDate.now().plusDays(1).atStartOfDay().plusHours(1));
        plannedEventRepository.save(plannedEvent);

        RepeatableEvent repeatableEvent = new RepeatableEvent();
        repeatableEvent.setName("Dummy Event 3");
        repeatableEvent.setStartDate(LocalDate.now().plusDays(1));
        repeatableEvent.setStartTime(LocalTime.now());
        repeatableEvent.setEndTime(LocalTime.now().plusHours(1));
        repeatableEvent.setRepeatInterval(2);
        repeatableEventRepository.save(repeatableEvent);
    }
}
