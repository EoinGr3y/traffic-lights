package com.traffic.sample.traffic.state;

public class RedLight implements LightState {

    @Override
    public String getLightState() {
        return "Red";
    }

    @Override
    public void changeState(TrafficLights trafficLights) {
        trafficLights.setLightState(new GreenLight());
    }
}
