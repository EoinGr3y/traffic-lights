package com.traffic.sample.traffic.service;

import com.traffic.sample.traffic.entity.HourOfDay;
import com.traffic.sample.traffic.repository.HourOfDayRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class HourDurationServiceTest {

    @TestConfiguration
    static class HourDurationServiceTestContextConfiguration {

        @Bean
        public HourDurationService hourDurationService() {
            return new HourDurationService();
        }
    }

    @Autowired
    private HourDurationService hourDurationService;

    @MockBean
    private HourOfDayRepository hourOfDayRepository;

    @Before
    public void setUp() {
        HourOfDay hourOfDay = new HourOfDay(-30, 90);

        Mockito.when(hourOfDayRepository.findByHour(hourOfDay.getHourOfDay()))
                .thenReturn(hourOfDay);
    }

    @Test
    public void whenValidHour_thenHourDurationShouldBeFound() {
        Integer hourOfDay = 90;

        Integer actualDuration = hourDurationService.findHourDurationMultiplier(hourOfDay);
        assertEquals(Integer.valueOf(-30), actualDuration);
    }

}
