package com.traffic.sample.traffic.states;

public interface LightState {

    String getLightState();

    void changeState(TrafficLights trafficLights);

}
