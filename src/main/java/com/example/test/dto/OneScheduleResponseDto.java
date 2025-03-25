package com.example.test.dto;

import com.example.test.entity.Schedule;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// 단건 응답 정보
@Getter
public class OneScheduleResponseDto {

    private String name;

    private String title;
    private String contents;

    private LocalDate startDate;
    private LocalDate lastDate;
    private LocalDateTime createDateTime;

    private String updateDateTime;

    // 시간 출력 수정
    public String formatter(LocalDateTime updateDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  HH : mm : ss");
        String updateTime = updateDateTime.format(formatter);
        return updateTime;
    }

    public OneScheduleResponseDto(Schedule schedule) {
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.startDate = schedule.getStartDate();
        this.lastDate = schedule.getLastDate();
        this.createDateTime = getCreateDateTime();
        this.updateDateTime = formatter(schedule.getUpdateDateTime());
    }
}
