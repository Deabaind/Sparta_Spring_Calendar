package com.example.test.repository;

import com.example.test.dto.CreateScheduleResponseDto;
import com.example.test.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // 일정 등록
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
        parameters.put("createDateTime", schedule.getCreateDateTime());
        parameters.put("updateDateTime", schedule.getUpdateDateTime());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        return new CreateScheduleResponseDto(key.longValue());
    }

    // 일정 목록 조회
    public List<Schedule> findAllSchedule() {
        return jdbcTemplate.query("select * from calendar.schedule", scheduleRowMapper());
    }

    // 일정 단건 조회
    public Optional<Schedule> findScheduleById(Long id) {
        List<Schedule> result = jdbcTemplate.query("select * from calendar.schedule where id = ?", scheduleRowMapperV2(), id);
        return result.stream().findAny();
    }

    // 일정 단건 수정
    public int updateSchedule(Long id, String name, String contents) {
        // 수정일.시간
        LocalDateTime updateDateTime = LocalDateTime.now();
        return jdbcTemplate.update("update schedule set name = ?, contents = ?, updateDateTime = ? where id = ?", name, contents, updateDateTime, id);
    }


    // 목록 조회용
    private RowMapper<Schedule> scheduleRowMapper() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("startDate").toLocalDate(),
                        rs.getDate("lastDate").toLocalDate(),
                        rs.getTimestamp("createDateTime").toLocalDateTime(),
                        rs.getTimestamp("updateDateTime").toLocalDateTime()
                );
            }
        };
    }

    // 단건 조회용
    private RowMapper<Schedule> scheduleRowMapperV2() {
        return new RowMapper<Schedule>() {
            @Override
            public Schedule mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Schedule(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("password"),
                        rs.getString("title"),
                        rs.getString("contents"),
                        rs.getDate("startDate").toLocalDate(),
                        rs.getDate("lastDate").toLocalDate(),
                        rs.getTimestamp("createDateTime").toLocalDateTime(),
                        rs.getTimestamp("updateDateTime").toLocalDateTime()
                );
            }

        };
    }
}


