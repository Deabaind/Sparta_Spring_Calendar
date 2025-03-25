package com.example.test.service;

import com.example.test.dto.ScheduleRequestDto;
import com.example.test.dto.ScheduleResponseDto;
import com.example.test.entity.Schedule;
import com.example.test.repository.ScheduleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public int create(ScheduleRequestDto requestDto) {
        return scheduleRepository.create(requestDto);
    }

    public List<ScheduleResponseDto> findAll() {
        return scheduleRepository.findAllSchedule();
    }

//    public Schedule findById(int id) {
//        return id;
//    }
}
