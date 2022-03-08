package me.louisdefromont.scheduleplanner;

import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Long>{
    
}
