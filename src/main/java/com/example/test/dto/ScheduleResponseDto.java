package com.example.test.dto;

import com.example.test.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleResponseDto {

    private int id;

    private String title;
    private String contents;

    private LocalDate startDate;
    private LocalDate lastDate;


    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.startDate = schedule.getStartDate();
        this.lastDate = schedule.getLastDate();
    }
}
