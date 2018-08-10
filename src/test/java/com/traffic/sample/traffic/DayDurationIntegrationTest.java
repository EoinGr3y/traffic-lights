package com.traffic.sample.traffic;

import com.traffic.sample.traffic.entity.DayOfWeek;
import com.traffic.sample.traffic.repository.DayOfWeekRepository;
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
public class DayDurationIntegrationTest {

    @Autowired
    private DayOfWeekRepository repository;

    @Test
    public void givenValidDay_whenFindByName_thenReturnDayOfWeek() {
        DayOfWeek monday = new DayOfWeek(1, "Monday");
        monday.setId(10001l);
        DayOfWeek actualDayOfWeek = repository.findByName("Monday");

        assertEquals(monday, actualDayOfWeek);
    }
}
