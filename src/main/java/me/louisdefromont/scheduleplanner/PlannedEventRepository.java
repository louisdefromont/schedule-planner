package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

public interface PlannedEventRepository extends CrudRepository<PlannedEvent, Long> {
}
