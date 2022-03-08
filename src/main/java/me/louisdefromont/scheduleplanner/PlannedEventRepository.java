package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

import me.louisdefromont.PlannedEvent;

public interface PlannedEventRepository extends CrudRepository<PlannedEvent, Long> {
}
