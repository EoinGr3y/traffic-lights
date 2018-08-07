package com.traffic.sample.traffic.repository;

import com.traffic.sample.traffic.entity.HourOfDay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class HourOfDayRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public HourOfDay findByHour(Integer hour) {
        return jdbcTemplate.queryForObject(
                "select * from hour_of_day where hour_of_day=?", new Object[] { hour }, new BeanPropertyRowMapper<HourOfDay>(HourOfDay.class));
    }

}
