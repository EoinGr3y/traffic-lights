package com.traffic.sample.traffic.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("test")
public class TrafficLightTestService implements TrafficLightService {

    @Override
    public void runTrafficLights() {

    }

    @Override
    public void setDurationMultiplier(final int durationMultiplier) {

    }
}
