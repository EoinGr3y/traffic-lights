package com.traffic.sample.traffic.repository;

import com.traffic.sample.traffic.entity.DayOfWeek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DayOfWeekRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public DayOfWeek findByName(String name) {
        return jdbcTemplate.queryForObject(
                "select * from day_of_week where name=?", new Object[] { name }, new BeanPropertyRowMapper<DayOfWeek>(DayOfWeek.class));
    }

    public List<String> findAllNames() {
        return jdbcTemplate.queryForList("select name from day_of_week", String.class);
    }

}
