package com.traffic.sample.traffic.service;

import com.traffic.sample.traffic.entity.DayOfWeek;
import com.traffic.sample.traffic.repository.DayOfWeekRepository;
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
public class DayDurationServiceTest {

    @TestConfiguration
    static class DayDurationServiceTestContextConfiguration {

        @Bean
        public DayDurationService dayDurationService() {
            return new DayDurationService();
        }
    }

    @Autowired
    private DayDurationService dayDurationService;

    @MockBean
    private DayOfWeekRepository dayOfWeekRepository;

    @Before
    public void setUp() {
        DayOfWeek newDay = new DayOfWeek(100, "New Day");

        Mockito.when(dayOfWeekRepository.findByName(newDay.getName()))
                .thenReturn(newDay);
    }

    @Test
    public void whenValidDay_thenDayDurationShouldBeFound() {
        String dayName = "New Day";

        Integer actualDuration = dayDurationService.findDayDurationMultiplier(dayName);
        assertEquals(Integer.valueOf(100), actualDuration);
    }

}
