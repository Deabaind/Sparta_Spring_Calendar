package com.example.test.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {

    // 일정 id

    private Long id;

    // 작성자, 비밀번호
    private String name;
    private String password;

    // 일정 제목, 내용
    private String title;
    private String contents;

    // 일정 시작일, 종료일, 작성일, 수정 날짜 및 시간
    private LocalDate startDate;
    private LocalDate lastDate;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public Schedule(String name, String password, String title, String contents, LocalDate startDate, LocalDate lastDate, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.name = name;
        this.password = password;
        this.title = title;
        this.contents = contents;
        this.startDate = startDate;
        this.lastDate = lastDate;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }
}
