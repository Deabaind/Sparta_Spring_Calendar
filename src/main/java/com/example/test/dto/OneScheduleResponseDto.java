package com.example.test.dto;

import com.example.test.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

// 단건 응답 정보
@Getter
@AllArgsConstructor
public class OneScheduleResponseDto {

    private String name;

    private String title;
    private String contents;

    private LocalDate startDate;
    private LocalDate lastDate;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public OneScheduleResponseDto(Schedule schedule) {
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.startDate = schedule.getStartDate();
        this.lastDate = schedule.getLastDate();
        this.createDateTime = schedule.getCreateDateTime();
        this.updateDateTime = schedule.getUpdateDateTime();
    }
}
