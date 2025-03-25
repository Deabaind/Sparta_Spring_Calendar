package com.example.test.dto;

import lombok.Getter;

@Getter
public class DeleteScheduleRequestDto {
    private String password;

    public DeleteScheduleRequestDto(String password) {
        this.password = password;
    }
}
