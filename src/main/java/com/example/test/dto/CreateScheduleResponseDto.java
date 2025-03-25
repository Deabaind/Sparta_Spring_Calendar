package com.example.test.dto;

import com.example.test.entity.Schedule;
import lombok.Getter;

@Getter
public class CreateScheduleResponseDto {
    private Long id;

    public CreateScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
    }
}
