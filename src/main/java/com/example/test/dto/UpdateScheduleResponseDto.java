package com.example.test.dto;

import com.example.test.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UpdateScheduleResponseDto {
    private String name;
    private String contents;
    private LocalDateTime updateDateTime;

    public UpdateScheduleResponseDto(Schedule schedule) {
        this.name = getName();
        this.contents = getContents();
        this.updateDateTime = getUpdateDateTime();
    }
}

