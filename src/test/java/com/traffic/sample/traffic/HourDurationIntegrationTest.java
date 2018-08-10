package com.traffic.sample.traffic;

import com.traffic.sample.traffic.entity.HourOfDay;
import com.traffic.sample.traffic.repository.HourOfDayRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HourDurationIntegrationTest {

    @Autowired
    private HourOfDayRepository repository;

    @Test
    public void givenValidHour_whenFindHour_thenReturnHourOfDay() {
        HourOfDay midnight = new HourOfDay(1, 0);
        midnight.setId(10001l);
        HourOfDay actualHourOfDay = repository.findByHour(0);

        assertEquals(midnight, actualHourOfDay);
    }
}
