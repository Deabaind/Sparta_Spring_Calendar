package com.example.test.service;

import com.example.test.dto.CreateScheduleResponseDto;
import com.example.test.dto.MultiScheduleResponseDto;
import com.example.test.dto.OneScheduleResponseDto;
import com.example.test.dto.ScheduleRequestDto;
import com.example.test.entity.Schedule;
import com.example.test.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // 생성
    public CreateScheduleResponseDto create(ScheduleRequestDto dto) {
        // 작성일.시간
        LocalDateTime createDateTime = LocalDateTime.now();
        // 수정일.시간
        LocalDateTime updateDateTime = LocalDateTime.now();

        // 빈 값으로 생성되지 않아 임의 값을 주입
        Long a = 0L;

        // a는 사용하지 않음
        Schedule schedule = new Schedule(a, dto.getName(), dto.getPassword(), dto.getTitle(), dto.getContents(), dto.getStartDate(), dto.getLastDate(), createDateTime, updateDateTime);

        return scheduleRepository.create(schedule);

    }

    // 목록 조회
    public List<Schedule> findAll() {
        return scheduleRepository.findAllSchedule();
    }

    // 단건 조회
    public OneScheduleResponseDto findScheduleById(Long id){
        Optional<Schedule> optionalSchedule = scheduleRepository.findScheduleById(id);

        if (optionalSchedule.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return new OneScheduleResponseDto(optionalSchedule.get());
    }
}


//    // 일정 생성
//    @PostMapping("/schedules")
//    public String createSchedule(@RequestBody ScheduleRequestDto requestDto) {
//        int result = scheduleService.create(requestDto);
//
//        if (result > 0) {
//            return "등록 성공";
//        } else {
//            return "등록 실패";
//        }
//    }
