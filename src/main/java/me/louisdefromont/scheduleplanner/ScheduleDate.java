package me.louisdefromont.scheduleplanner;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ScheduleDate {
    @Id
    private int id;
    private LocalDate date;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ScheduledEvent> events;
}
