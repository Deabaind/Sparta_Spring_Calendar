package com.example.test.dto;

import com.example.test.entity.Schedule;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ScheduleResponseDto {

    private Integer id;

    private String name;

    private String title;
    private String contents;

    private LocalDate startDate;
    private LocalDate lastDate;
    private LocalDate updateDate;

    public ScheduleResponseDto() {}
}
