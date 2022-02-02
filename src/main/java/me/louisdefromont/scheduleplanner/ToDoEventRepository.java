package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

public interface ToDoEventRepository extends CrudRepository<ToDoEvent, Long> {
}
