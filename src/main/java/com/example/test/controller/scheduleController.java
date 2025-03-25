package com.example.test.controller;

import com.example.test.dto.ScheduleRequestDto;
import com.example.test.dto.ScheduleResponseDto;
import com.example.test.entity.Schedule;
import com.example.test.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class scheduleController {

    private final ScheduleService scheduleService;

    // 일정 생성
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        return ScheduleService.create()
    }

    // 일정 목록 조회

    // 일정 단일 조회
    @GetMapping("/schedules/{id}")
    public ResponseEntity<Schedule> findschedule(@PathVariable int id){
        Schedule schedule = scheduleService.findById(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    // 일정 업데이트

    // 일정 삭제


}
