package com.traffic.sample.traffic.state;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YellowLight implements LightState {

    private static Logger logger = LoggerFactory.getLogger(YellowLight.class);

    @Override
    public String getLightState() {
        return "Yellow";
    }

    @Override
    public void changeState(final TrafficLights trafficLights) {
        trafficLights.setLightState(new RedLight());
    }
}
