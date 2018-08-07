package com.traffic.sample.traffic;

import com.traffic.sample.traffic.repository.DayOfWeekRepository;
import com.traffic.sample.traffic.repository.HourOfDayRepository;
import com.traffic.sample.traffic.state.RedLight;
import com.traffic.sample.traffic.state.TrafficLights;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrafficLightsApplication implements CommandLineRunner {

    @Autowired
    DayOfWeekRepository dayOfWeekRepository;
    @Autowired
    HourOfDayRepository hourOfDayRepository;

	private static Logger logger = LoggerFactory.getLogger(TrafficLightsApplication.class);

	public static void main(String[] args) {
	    SpringApplication.run(TrafficLightsApplication.class, args);
	}

    @Override
    public void run(final String... args) throws Exception {
        logger.info("Monday database entry -> {}", dayOfWeekRepository.findByName("Monday"));
        logger.info("Monday database duration -> {}", dayOfWeekRepository.findByName("Monday").getDuration());

        logger.info("10am database entry -> {}", hourOfDayRepository.findByHour(10));
        logger.info("10am database duration -> {}", hourOfDayRepository.findByHour(10).getDuration());

        //        TrafficLights trafficLights = new TrafficLights(new RedLight());

//        for(int i = 0; i < 5; i++) {
//            logger.info("Current light colour is {}", trafficLights.getCurrentLightColour());
//            Thread.sleep(2000);
//            trafficLights.changeState();
//            logger.info("Light colour changed");
//        }
    }
}
