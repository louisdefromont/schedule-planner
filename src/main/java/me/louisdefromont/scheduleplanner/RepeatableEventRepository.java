package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

public interface RepeatableEventRepository extends CrudRepository<RepeatableEvent, Long> {
}
