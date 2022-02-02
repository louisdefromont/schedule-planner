package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

public interface ScheduledEventRepository extends CrudRepository<ScheduledEvent, Long> {
}
