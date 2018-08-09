package com.traffic.sample.traffic.service;

import com.traffic.sample.traffic.repository.DayOfWeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayDurationService {

    @Autowired
    DayOfWeekRepository dayOfWeekRepository;

    public Integer findDayDurationMultiplier(final String dayOfWeek) {
        return dayOfWeekRepository.findByName(dayOfWeek).getDuration();
    }

}
