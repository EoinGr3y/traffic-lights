package com.traffic.sample.traffic;

import com.traffic.sample.traffic.service.DayDurationService;
import com.traffic.sample.traffic.service.HourDurationService;
import com.traffic.sample.traffic.service.TrafficLightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.traffic.sample")
public class TrafficLightsApplication implements CommandLineRunner {

    @Autowired
    private DayDurationService dayDurationService;
    @Autowired
    private HourDurationService hourDurationService;
    @Autowired
    private TrafficLightService trafficLightService;

    private static Logger logger = LoggerFactory.getLogger(TrafficLightsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrafficLightsApplication.class, args);
    }

    /**
     * Run with mvn spring-boot:run -Dspring-boot.run.arguments="Wednesday,3" to configure day and hour.
     * Run with mvn clean install -Dspring.profiles.active=test to run tests.
     */
    @Override
    public void run(final String... args) throws InterruptedException {
        // default values if no args are given.
        String dayOfWeek = "Monday";
        String hourOfDay = "0";
        if (args.length >= 2) {
            dayOfWeek = args[0];
            hourOfDay = args[1];
        }

        Integer dayDurationMultiplier = dayDurationService.findDayDurationMultiplier(dayOfWeek);
        Integer hourDurationMultiplier = hourDurationService.findHourDurationMultiplier(Integer.valueOf(hourOfDay));

        int durationMultiplier = dayDurationMultiplier + hourDurationMultiplier;
        logger.info("Duration multiplier -> {}", durationMultiplier);
        trafficLightService.setDurationMultiplier(durationMultiplier);
        trafficLightService.runTrafficLights();
    }

}
