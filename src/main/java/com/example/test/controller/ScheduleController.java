package com.example.test.controller;

import com.example.test.dto.*;
import com.example.test.entity.Schedule;

import com.example.test.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    private Map<Long, Schedule> scheduleList = new HashMap<>();

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 일정 생성
    @PostMapping
    public ResponseEntity<CreateScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto) {
        CreateScheduleResponseDto CreateScheduleResponseDto = scheduleService.create(dto);
        return new ResponseEntity<>(CreateScheduleResponseDto, HttpStatus.OK);
    }

    // 목록 조회
    @GetMapping
    public List<MultiScheduleResponseDto> findAllSchedule() {

        List<MultiScheduleResponseDto> multiResponseList = new ArrayList<>();

        for (Schedule schedule : scheduleService.findAll()) {
            MultiScheduleResponseDto responseDto = new MultiScheduleResponseDto(schedule);
            multiResponseList.add(responseDto);
        }
        // updateDateTime을 기준으로 내림차순
        multiResponseList.sort(Comparator.comparing(MultiScheduleResponseDto::getUpdateDateTime));

        return multiResponseList;
    }

    // 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<OneScheduleResponseDto> findScheduleId(@PathVariable Long id) {
        OneScheduleResponseDto oneResponseDto = scheduleService.findScheduleById(id);

        return new ResponseEntity<>(oneResponseDto, HttpStatus.OK);
    }

    // 단건 수정
    @PutMapping("/{id}")
    public ResponseEntity<OneScheduleResponseDto> updateScheduleById(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto dto
    ) {
        OneScheduleResponseDto updateResponseDto = scheduleService.findScheduleById(id);

        scheduleService.updateSchedule(id, dto.getName(), dto.getContents(), dto.getPassword());

        return new ResponseEntity<>(updateResponseDto, HttpStatus.OK);
    }

    // 단건 삭제
    @DeleteMapping("/{id}")
    public void deleteSchedule(
            @PathVariable Long id,
            @RequestBody DeleteScheduleRequestDto dto
    ) {
        Schedule schedule = scheduleList.get(id);

        if (schedule.getPassword().equals(dto.getPassword())) {
            scheduleList.remove(id);
        }
    }
}
