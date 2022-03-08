package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

import me.louisdefromont.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long>{
    
}
