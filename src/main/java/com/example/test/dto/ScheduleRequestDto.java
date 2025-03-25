package com.example.test.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ScheduleRequestDto {

    private String name;
    private String password;

    private String title;
    private String contents;

    private LocalDate startDate;
    private LocalDate lastDate;

    public ScheduleRequestDto(String name, String password, String title, String contents, LocalDate startDate, LocalDate lastDate) {
        this.name = name;
        this.password = password;
        this.title = title;
        this.contents = contents;
        this.startDate = startDate;
        this.lastDate = lastDate;
    }
}
