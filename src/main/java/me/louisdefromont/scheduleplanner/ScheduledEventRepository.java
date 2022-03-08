package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

import me.louisdefromont.ScheduledEvent;

public interface ScheduledEventRepository extends CrudRepository<ScheduledEvent, Long> {
}
