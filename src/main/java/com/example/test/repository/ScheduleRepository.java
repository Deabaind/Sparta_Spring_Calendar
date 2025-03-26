package com.example.test.repository;



//import com.example.test.dto.ScheduleResponseDto;
//import com.example.test.entity.Schedule;
import com.example.test.dto.CreateScheduleResponseDto;
import com.example.test.dto.ScheduleRequestDto;
import com.example.test.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public CreateScheduleResponseDto create(Schedule schedule) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);

        // Key 값은 id로 설정
        jdbcInsert.withTableName("schedule").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", schedule.getName());
        parameters.put("password", schedule.getPassword());
        parameters.put("title", schedule.getTitle());
        parameters.put("contents", schedule.getContents());
        parameters.put("startDate", schedule.getStartDate());
        parameters.put("lastDate", schedule.getLastDate());
        parameters.put("createDate", schedule.getCreateDateTime());
        parameters.put("updateDate", schedule.getUpdateDateTime());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new CreateScheduleResponseDto(key.longValue());

        }

//    public List<ScheduleResponseDto> findAllSchedule() {
//        String sql = "select name, title, startDate, lastDate, updateDate from calendar.schedule";
//        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ScheduleResponseDto.class));
//    }

}

