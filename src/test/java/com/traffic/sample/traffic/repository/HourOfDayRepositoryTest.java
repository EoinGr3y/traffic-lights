package com.traffic.sample.traffic.repository;

import com.traffic.sample.traffic.entity.HourOfDay;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@DirtiesContext
public class HourOfDayRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private HourOfDayRepository hourOfDayRepository;

    @Test
    public void whenFindByName_thenReturnDayOfWeek() {
        HourOfDay newHour = new HourOfDay(100, 90);
        entityManager.persist(newHour);
        entityManager.flush();

        HourOfDay actualHourOfDay = hourOfDayRepository.findByHour(90);

        assertEquals(newHour.getDuration(), actualHourOfDay.getDuration());
    }

}
