package com.example.test.entity;


import com.example.test.dto.UpdateScheduleRequestDto;
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
    private LocalDateTime updateDateTime = LocalDateTime.now();

    public void update(UpdateScheduleRequestDto dto) {
        this.name = dto.getName();
        this.password = dto.getPassword();
        this.contents = dto.getContents();
        this.updateDateTime = LocalDateTime.now();
    }
}
