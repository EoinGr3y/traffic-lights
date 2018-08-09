package com.traffic.sample.traffic.repository;

import com.traffic.sample.traffic.entity.DayOfWeek;
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
public class DayOfWeekRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private DayOfWeekRepository dayOfWeekRepository;

    @Test
    public void whenFindByName_thenReturnDayOfWeek() {
        DayOfWeek newDay = new DayOfWeek(1, "New Day");
        entityManager.persist(newDay);
        entityManager.flush();

        DayOfWeek actualDayOfWeek = dayOfWeekRepository.findByName(newDay.getName());

        assertEquals(newDay.getName(), actualDayOfWeek.getName());
    }

}
