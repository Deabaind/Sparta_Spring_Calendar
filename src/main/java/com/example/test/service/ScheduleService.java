package com.example.test.service;

import com.example.test.entity.Schedule;
import com.example.test.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {


    public static Schedule create(Schedule schedule) {
        return ScheduleRepository.create(schedule);
    }

    public Schedule findById(int id) {
        return id;
    }
}
