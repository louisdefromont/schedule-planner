package me.louisdefromont.scheduleplanner;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import me.louisdefromont.ToDoEvent;

public interface ToDoEventRepository extends CrudRepository<ToDoEvent, Long> {
    Optional<ToDoEvent> findTopByOrderByDueDateTimeDesc();
}
