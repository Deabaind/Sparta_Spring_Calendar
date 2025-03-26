package com.example.test.dto;

import com.example.test.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 다건 응답 정보
@Getter
@AllArgsConstructor
public class MultiScheduleResponseDto {

    private  Long id;

    private String name;

    private String title;

    private LocalDate startDate;
    private LocalDate lastDate;
    private LocalDateTime updateDateTime;

    public MultiScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.startDate = schedule.getStartDate();
        this.lastDate = schedule.getLastDate();
        this.updateDateTime = schedule.getUpdateDateTime();
    }
}
