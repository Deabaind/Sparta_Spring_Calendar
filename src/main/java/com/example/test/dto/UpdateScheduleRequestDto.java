package com.example.test.dto;


import lombok.Getter;

@Getter
public class UpdateScheduleRequestDto {
    private String name;
    private String password;
    private String contents;

    public UpdateScheduleRequestDto(String name, String password, String contents) {
        this.name = name;
        this.password = password;
        this.contents = contents;
    }
}
