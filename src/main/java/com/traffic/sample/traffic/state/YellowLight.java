package com.traffic.sample.traffic.state;

public class YellowLight implements LightState {

    @Override
    public String getLightState() {
        return "Yellow";
    }

    @Override
    public void changeState(final TrafficLights trafficLights) {
        trafficLights.setLightState(new RedLight());
    }
}
