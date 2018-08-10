package com.traffic.sample.traffic.service;

import com.traffic.sample.traffic.repository.HourOfDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HourDurationService {

    @Autowired
    private HourOfDayRepository hourOfDayRepository;

    public Integer findHourDurationMultiplier(final Integer hourOfDay) {
        return hourOfDayRepository.findByHour(hourOfDay).getDuration();
    }
}
