package me.louisdefromont.scheduleplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.louisdefromont.PlannedEvent;
import me.louisdefromont.RepeatableEvent;
import me.louisdefromont.ToDoEvent;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private PlannedEventRepository plannedEventRepository;

    @Autowired
    private RepeatableEventRepository repeatableEventRepository;

    @Autowired
    private ToDoEventRepository toDoEventRepository;

    @PostMapping(path = "/plannedEvents")
    public PlannedEvent savePlannedEvent(@RequestBody PlannedEvent plannedEvent) {
        return plannedEventRepository.save(plannedEvent);
    }

    @PostMapping(path = "/repeatableEvents")
    public RepeatableEvent saveRepeatableEvent(@RequestBody RepeatableEvent repeatableEvent) {
        return repeatableEventRepository.save(repeatableEvent);
    }

    @PostMapping(path = "/toDoEvents")
    public ToDoEvent saveToDoEvent(@RequestBody ToDoEvent toDoEvent) {
        return toDoEventRepository.save(toDoEvent);
    }

    @GetMapping(path = "/plannedEvents")
    public Iterable<PlannedEvent> getPlannedEvents() {
        return plannedEventRepository.findAll();
    }

    @GetMapping(path = "/repeatableEvents")
    public Iterable<RepeatableEvent> getRepeatableEvents() {
        return repeatableEventRepository.findAll();
    }

    @GetMapping(path = "/toDoEvents")
    public Iterable<ToDoEvent> getToDoEvents() {
        return toDoEventRepository.findAll();
    }

    @DeleteMapping(path = "/plannedEvents")
    public void deletePlannedEvent(@RequestBody PlannedEvent plannedEvent) {
        plannedEventRepository.delete(plannedEvent);
    }

    @DeleteMapping(path = "/repeatableEvents")
    public void deleteRepeatableEvent(@RequestBody RepeatableEvent repeatableEvent) {
        repeatableEventRepository.delete(repeatableEvent);
    }

    @DeleteMapping(path = "/toDoEvents")
    public void deleteToDoEvent(@RequestBody ToDoEvent toDoEvent) {
        toDoEventRepository.delete(toDoEvent);
    }
}
