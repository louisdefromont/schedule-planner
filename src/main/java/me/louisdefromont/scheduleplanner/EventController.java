package me.louisdefromont.scheduleplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.louisdefromont.PlannedEvent;
import me.louisdefromont.RepeatableEvent;
import me.louisdefromont.ToDoEvent;

@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private PlannedEventRepository plannedEventRepository;

    @Autowired
    private RepeatableEventRepository repeatableEventRepository;

    @Autowired
    private ToDoEventRepository toDoEventRepository;

    @PostMapping(path = "/plannedEvent")
    public PlannedEvent newPlannedEvent(@RequestBody PlannedEvent plannedEvent) {
        return plannedEventRepository.save(plannedEvent);
    }

    @PostMapping(path = "/repeatableEvent")
    public RepeatableEvent newRepeatableEvent(@RequestBody RepeatableEvent repeatableEvent) {
        return repeatableEventRepository.save(repeatableEvent);
    }

    @PostMapping(path = "/toDoEvent")
    public ToDoEvent newToDoEvent(@RequestBody ToDoEvent toDoEvent) {
        return toDoEventRepository.save(toDoEvent);
    }
}
