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
}
