package me.louisdefromont.scheduleplanner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @PostMapping(path = "/generate")
    public List<ScheduleDate> generateSchedule() {
        LocalDate generateUntil = LocalDate.now();
        Optional<ToDoEvent> lastToDoEvent = toDoEventRepository.findTopByOrderByDueDateTimeDesc();
        if (lastToDoEvent.isPresent()) {
            generateUntil = lastToDoEvent.get().getDueDateTime().toLocalDate();
        }
        
        return null;
    }

    @PostMapping(path = "/addDummyData")
    public void addDummyData() {
        ToDoEvent toDoEvent = new ToDoEvent();
        Event event = new Event();
        event.setName("Dummy Event");
        event.setEnergyDrain(1.0);
        toDoEvent.setEvent(event);
        toDoEvent.setDueDateTime(LocalDate.now().plusDays(1).atStartOfDay());
        toDoEvent.setEstimatedMinutes(30);
        toDoEventRepository.save(toDoEvent);
    }
}
