package com.traffic.sample.traffic;

import com.traffic.sample.traffic.states.RedLight;
import com.traffic.sample.traffic.states.TrafficLights;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrafficLightsApplication {

	private static Logger logger = LoggerFactory.getLogger(TrafficLightsApplication.class);

	public static void main(String[] args) throws InterruptedException {
	    SpringApplication.run(TrafficLightsApplication.class, args);
        TrafficLights trafficLights = new TrafficLights(new RedLight());

        for(int i = 0; i < 5; i++) {
            logger.info("Current light colour is {}", trafficLights.getCurrentLightColour());
            Thread.sleep(2000);
            trafficLights.changeState();
            logger.info("Light colour changed");
        }
	}
}
