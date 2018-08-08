package com.traffic.sample.traffic;

import com.traffic.sample.traffic.entity.DayOfWeek;
import com.traffic.sample.traffic.entity.HourOfDay;
import com.traffic.sample.traffic.repository.DayOfWeekRepository;
import com.traffic.sample.traffic.repository.HourOfDayRepository;
import com.traffic.sample.traffic.service.DayDurationService;
import com.traffic.sample.traffic.service.HourDurationService;
import com.traffic.sample.traffic.state.RedLight;
import com.traffic.sample.traffic.state.TrafficLights;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
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
    public void run(final String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String dayOfWeek = readDayOfWeek(scanner);
        System.out.println("Day of week input = " + dayOfWeek);

        Integer hourOfDay = readHourOfDay(scanner);
        System.out.println("Hour of day input = " + hourOfDay);

        scanner.close();

        Integer hourDurationMultiplier = hourDurationService.findDayDurationMultiplier(hourOfDay);

//        Integer durationMultiplier = dayDurationMultiplier + hourDurationMultiplier;
//        logger.info("Duration multiplier -> {}", durationMultiplier);
//
//        TrafficLights trafficLights = new TrafficLights(new RedLight());
//
//        for (int i = 0; i < 5; i++) {
//            logger.info("Current light colour is {}", trafficLights.getCurrentLightColour());
//            Thread.sleep(durationMultiplier * 1000);
//            trafficLights.changeState();
//            logger.info("Light colour changed");
//        }
    }

    private String readDayOfWeek(Scanner scanner) {
        List<String> validDays = dayDurationService.findAllPossibleDays();
        System.out.println("Please input current day of the week: ");
        while (!scanner.hasNext("(Mon|Tues|Wednes|Thurs|Fri|Satur|Sun)(day)")) {
            System.out.println("That's not a day of the week, valid options are: " + validDays.toString());
            scanner.next();
        }
        String dayOfWeek = scanner.next();
        return dayOfWeek;
    }

    private Integer readHourOfDay(Scanner scanner) {
        Integer result;
        System.out.println("Please input current hour of the day: ");
        while (!scanner.hasNextInt() || (result = scanner.nextInt()) < 0 || (result = scanner.nextInt()) > 23) {
            System.out.println("That's not a valid hour of day, valid options are: 0 - 23");
            scanner.nextInt();
        }
        Integer dayOfWeek = scanner.nextInt();
        return dayOfWeek;
    }
}
