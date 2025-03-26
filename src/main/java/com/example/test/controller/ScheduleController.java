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
//@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    private final Map<Long, Schedule> scheduleList = new HashMap<>();

    @PostMapping
    public ResponseEntity<CreateScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto dto) {
        CreateScheduleResponseDto CreateScheduleResponseDto = scheduleService.create(dto);
        return new ResponseEntity<>(CreateScheduleResponseDto, HttpStatus.OK);
    }

    // 생성
//    @PostMapping
//    public CreateScheduleResponseDto createSchedule(@RequestBody ScheduleRequestDto dto) {
//        // 식별자가 1씩 증가 하도록 만듦
//        Long id = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
//
//        LocalDateTime createDatetime = LocalDateTime.now();
//        LocalDateTime updateDateTime = LocalDateTime.now();
//
//        // 요청받은 데이터로 Schedule 객체 생성
//        Schedule schedule = new Schedule(
//                id,
//                dto.getName(),
//                dto.getPassword(),
//                dto.getTitle(),
//                dto.getContents(),
//                dto.getStartDate(),
//                dto.getLastDate(),
//                createDatetime,
//                updateDateTime
//        );
//
//        scheduleList.put(id, schedule);
//
//        return new CreateScheduleResponseDto(schedule);
//    }

    // 목록 조회
    @GetMapping
    public List<MultiScheduleResponseDto> findAllSchedule() {
        List<MultiScheduleResponseDto> multiResponseList = new ArrayList<>();

        for (Schedule schedule : scheduleList.values()) {
            MultiScheduleResponseDto multiScheduleResponseDto = new MultiScheduleResponseDto(schedule);
            multiResponseList.add(multiScheduleResponseDto);
        }
        // updateDate를 기준으로 내림차순
        multiResponseList.sort(Comparator.comparing(MultiScheduleResponseDto::getUpdateDate));
        return multiResponseList;
    }

    // 단건 조회
    @GetMapping("/{id}")
    public OneScheduleResponseDto findScheduleId(@PathVariable Long id) {
        Schedule schedule = scheduleList.get(id);

        return new OneScheduleResponseDto(schedule);
    }

    // 단건 수정
    @PutMapping("/{id}")
    public OneScheduleResponseDto updateScheduleById(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto dto
    ) {
        Schedule schedule = scheduleList.get(id);

        if (schedule.getPassword().equals(dto.getPassword())) {
            schedule.update(dto);
        }
        // 비밀번호가 틀릴 경우 예외처리
//        else {
//
//        }

        return new OneScheduleResponseDto(schedule);
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
