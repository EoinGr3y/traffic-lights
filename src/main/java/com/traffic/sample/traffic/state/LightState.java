package com.traffic.sample.traffic.state;

public interface LightState {

    String getLightState();

    void changeState(TrafficLights trafficLights);

}
