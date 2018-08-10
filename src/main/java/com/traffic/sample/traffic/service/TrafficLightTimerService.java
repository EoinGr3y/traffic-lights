package com.traffic.sample.traffic.service;

import com.traffic.sample.traffic.state.RedLight;
import com.traffic.sample.traffic.state.TrafficLights;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!test")
public class TrafficLightTimerService implements TrafficLightService {

    private static Logger logger = LoggerFactory.getLogger(TrafficLightTimerService.class);

    private int durationMultiplier;

    @Override
    public void runTrafficLights() throws InterruptedException {
        TrafficLights trafficLights = new TrafficLights(new RedLight());

        for (int i = 0; i < 5; i++) {
            logger.info("Current light colour is {}", trafficLights.getCurrentLightColour());
            Thread.sleep(durationMultiplier * 1000);
            trafficLights.changeState();
            logger.info("Light colour changed");
        }

    }

    @Override
    public void setDurationMultiplier(final int durationMultiplier) {
        this.durationMultiplier = durationMultiplier;
    }
}
