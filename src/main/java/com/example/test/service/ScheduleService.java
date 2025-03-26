package com.example.test.service;

import com.example.test.dto.*;
import com.example.test.entity.Schedule;
import com.example.test.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        // 강의에서는 auto increment 이기에 빈 값으로 입력했으나 코드를 수정하고 적용하니 실행되지 않음
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

    @Transactional
    // 일정 단건 수정
    public UpdateScheduleResponseDto updateSchedule(Long id, String name, String contents, String password) {
        if (name == null || contents == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "the");
        }

        int updateRow = scheduleRepository.updateSchedule(id, name, contents);

        if (updateRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does");
        }

        Optional<Schedule> optionalSchedule = scheduleRepository.findScheduleById(id);

        return new UpdateScheduleResponseDto(optionalSchedule.get());
    }
}