package com.example.test.dto;

import com.example.test.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;


@Getter
public class ScheduleResponseDto {

    private Long id;

    private String name;

    private String title;
    private String contents;

    private LocalDate startDate;
    private LocalDate lastDate;
    private LocalDate updateDate;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.startDate = schedule.getStartDate();
        this.lastDate = schedule.getLastDate();
        this.updateDate = schedule.getUpdateDate();
    }
}
