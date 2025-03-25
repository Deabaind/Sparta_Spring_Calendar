package com.example.test.controller;

import com.example.test.domain.Schedule;
import com.example.test.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class scheduleController {

    private final ScheduleService scheduleService;
    // 일정 생성

    // 일정 목록 조회

    // 일정 단일 조회
    @GetMapping("/schedules/{schedule_ID}")
    public ResponseEntity<String> findschedule(@PathVariable int schedule_ID){
        Schedule schedule = scheduleService.findById(schedule_ID);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    // 일정 업데이트

    // 일정 삭제


}
