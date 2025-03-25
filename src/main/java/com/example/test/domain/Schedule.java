package com.example.test.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter@NoArgsConstructor
public class Schedule {

    private int schedule_Id;
    private int user_Id;
    private String title;
    private String contents;
}
