package com.example.test.repository;


//import com.example.test.dto.ScheduleRequestDto;
//import com.example.test.dto.ScheduleResponseDto;
//import com.example.test.entity.Schedule;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class ScheduleRepository {

//    private JdbcTemplate jdbcTemplate;
//
//    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public int create(ScheduleRequestDto requestDto) {
//        String sql = "insert into calendar.schedule (name, password, title, contents, startDate, lastDate) Values (?, ?, ?, ?, ?, ?, ?)";
//        LocalDate updateDate = LocalDate.now();
//        return jdbcTemplate.update(sql, requestDto.getName(), requestDto.getPassword(), requestDto.getTitle(), requestDto.getContents(), requestDto.getStartDate(), requestDto.getLastDate(), updateDate);
//    }
//
//    public List<ScheduleResponseDto> findAllSchedule() {
//        String sql = "select name, title, startDate, lastDate, updateDate from calendar.schedule";
//        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ScheduleResponseDto.class));
//    }

}

