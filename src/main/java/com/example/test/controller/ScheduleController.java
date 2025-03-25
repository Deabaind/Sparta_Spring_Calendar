package com.example.test.controller;

import com.example.test.dto.ScheduleRequestDto;
import com.example.test.dto.ScheduleResponseDto;
import com.example.test.entity.Schedule;
import com.example.test.service.ScheduleService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/schedules")
//@RequiredArgsConstructor
public class ScheduleController {

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {
        // 식별자가 1씩 증가 하도록 만듦
        Long id = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;

        // 오늘 날짜
        LocalDate updateDate = LocalDate.now();

        // 임시 비밀번호
        String password = "왜 안나옴";

        // 요청받은 데이터로 Schedule 객체 생성
        Schedule schedule = new Schedule(
                id,
                dto.getName(),
                password,
                dto.getTitle(),
                dto.getContents(),
                dto.getStartDate(),
                dto.getLastDate(),
                updateDate
        );

        // Inmemory DB에 Memo 저장
        scheduleList.put(id, schedule);

        return new ScheduleResponseDto(schedule);
    }

    @GetMapping("/{id}")
    public ScheduleResponseDto findScheduleId(@PathVariable Long id) {
        Schedule schedule = scheduleList.get(id);

        return new ScheduleResponseDto(schedule);
    }

    @GetMapping("/{id}")
    public ScheduleResponseDto updateScheduleById(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto dto
    ) {
        Schedule schedule = scheduleList.get(id);

        schedule.update(dto);

    }

//    private final ScheduleResponseDto scheduleService

//    public ScheduleController(ScheduleService scheduleService) {
//        this.scheduleService = scheduleService;
//    }

//    // 일정 생성
//    @PostMapping("/schedules")
//    public String createSchedule(@RequestBody ScheduleRequestDto requestDto) {
//        int result = scheduleService.create(requestDto);
//
//        if (result > 0) {
//            return "등록 성공";
//        } else {
//            return "등록 완료";
//        }
//    }
//
//    // 일정 목록 조회
//    @GetMapping("/schedules")
//    public ResponseEntity<ScheduleResponseDto> findAllSchedule(){
//        Schedule schedule = scheduleService.findAll();
//        return
//    }
//
//    // 일정 단일 조회
//    @GetMapping("/schedules/{id}")
//    public ResponseEntity<Schedule> findschedule(@PathVariable int id){
//        Schedule schedule = scheduleService.findById(id);
//        return new ResponseEntity<>(schedule, HttpStatus.OK);
//    }

    // 일정 업데이트

    // 일정 삭제


}
