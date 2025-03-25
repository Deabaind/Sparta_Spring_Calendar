package com.example.test.controller;

import com.example.test.dto.ScheduleRequestDto;
import com.example.test.dto.ScheduleResponseDto;
import com.example.test.entity.Schedule;
import com.example.test.service.ScheduleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules")
//@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 생성
    @PostMapping("/schedules")
    public String createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        int result = scheduleService.create(requestDto);

        if (result > 0) {
            return "등록 성공";
        } else {
            return "등록 완료";
        }
    }

    // 일정 목록 조회
    @GetMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> findAllSchedule(){
        Schedule schedule = scheduleService.findAll();
        return
    }

    // 일정 단일 조회
    @GetMapping("/schedules/{id}")
    public ResponseEntity<Schedule> findschedule(@PathVariable int id){
        Schedule schedule = scheduleService.findById(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    // 일정 업데이트

    // 일정 삭제


}
