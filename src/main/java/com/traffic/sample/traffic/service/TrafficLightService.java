package com.traffic.sample.traffic.service;

public interface TrafficLightService {

    void runTrafficLights() throws InterruptedException;

    void setDurationMultiplier(int durationMultiplier);
}
