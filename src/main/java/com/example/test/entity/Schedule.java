package com.example.test.entity;


import com.example.test.dto.ScheduleRequestDto;
import com.example.test.dto.ScheduleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

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

    // 일정 시작일, 종료일, 수정일
    private LocalDate startDate;
    private LocalDate lastDate;
    private LocalDate updateDate = LocalDate.now();

    public void update(ScheduleResponseDto dto) {
        this.name = dto.getName();
        this.title = dto.getTitle();
        this.contents = dto.getTitle();
        this.startDate = dto.getStartDate();
        this.lastDate = dto.getLastDate();
    }
}
