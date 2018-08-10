package com.traffic.sample.traffic.state;

public class GreenLight implements LightState {

    @Override
    public String getLightState() {
        return "Green";
    }

    @Override
    public void changeState(final TrafficLights trafficLights) {
        trafficLights.setLightState(new YellowLight());
    }
}
