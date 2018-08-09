package com.traffic.sample.traffic;

import com.traffic.sample.traffic.service.DayDurationService;
import com.traffic.sample.traffic.service.HourDurationService;
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

    private static Logger logger = LoggerFactory.getLogger(TrafficLightsApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TrafficLightsApplication.class, args);
    }

    @Override
    public void run(final String... args) {
        String dayOfWeek = "Monday";
        String hourOfDay = "0";
        if(args.length >= 2) {
            dayOfWeek = args[0];
            hourOfDay = args[1];
        }

        Integer dayDurationMultiplier = dayDurationService.findDayDurationMultiplier(dayOfWeek);
        Integer hourDurationMultiplier = hourDurationService.findHourDurationMultiplier(Integer.valueOf(hourOfDay));

        Integer durationMultiplier = dayDurationMultiplier + hourDurationMultiplier;
        logger.info("Duration multiplier -> {}", durationMultiplier);

//        TrafficLights trafficLights = new TrafficLights(new RedLight());
//
//        for (int i = 0; i < 5; i++) {
//            logger.info("Current light colour is {}", trafficLights.getCurrentLightColour());
//            Thread.sleep(durationMultiplier * 1000);
//            trafficLights.changeState();
//            logger.info("Light colour changed");
//        }
    }

}
