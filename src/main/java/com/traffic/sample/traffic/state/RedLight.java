package com.traffic.sample.traffic.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RedLight implements LightState {

    private static Logger logger = LoggerFactory.getLogger(RedLight.class);

    @Override
    public String getLightState() {
        return "Red";
    }

    @Override
    public void changeState(TrafficLights trafficLights) {
        trafficLights.setLightState(new GreenLight());
    }
}
