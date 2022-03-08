package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

import me.louisdefromont.RepeatableEvent;

public interface RepeatableEventRepository extends CrudRepository<RepeatableEvent, Long> {
}
