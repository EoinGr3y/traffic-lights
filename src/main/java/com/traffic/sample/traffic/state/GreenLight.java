package com.traffic.sample.traffic.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GreenLight implements LightState {

    private static Logger logger = LoggerFactory.getLogger(GreenLight.class);

    @Override
    public String getLightState() {
        return "Green";
    }

    @Override
    public void changeState(final TrafficLights trafficLights) {
        trafficLights.setLightState(new YellowLight());
    }
}
