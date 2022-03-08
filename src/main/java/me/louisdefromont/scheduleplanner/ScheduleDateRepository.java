package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

import me.louisdefromont.ScheduleDate;

public interface ScheduleDateRepository  extends CrudRepository<ScheduleDate, Long> {

}
