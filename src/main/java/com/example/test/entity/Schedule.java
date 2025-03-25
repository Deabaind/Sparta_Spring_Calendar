package com.example.test.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class Schedule {

    // 일정 id
    private int id;

    // 작성자, 비밀번호
    private String name;
    private String password;

    // 일정 제목, 내용
    private String title;
    private String contents;

    // 일정 시작일, 종료일, 수정일
    private LocalDate startDate;
    private LocalDate lastDate;
    private LocalDate updateDate;
}
