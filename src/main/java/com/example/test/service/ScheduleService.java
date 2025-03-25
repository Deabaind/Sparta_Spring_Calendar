package com.example.test.service;

import com.example.test.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;

    public Schedule findById(int scheduleId) {
        return scheduleRepository.findById(scheduleId);
    }
}
