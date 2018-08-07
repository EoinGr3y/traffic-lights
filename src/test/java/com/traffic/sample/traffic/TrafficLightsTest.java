package com.traffic.sample.traffic;

import com.traffic.sample.traffic.state.*;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class TrafficLightsTest {

    @Test
    @Parameters(method = "parametersToTestTrafficLight")
    public void forGivenLightState_displayTrafficLightState(LightState initialState, String expectedColour, String expectedChangedColour) {
        TrafficLights trafficLights = new TrafficLights(initialState);
        assertEquals(expectedColour, trafficLights.getCurrentLightColour());

        trafficLights.changeState();
        assertEquals(expectedChangedColour, trafficLights.getCurrentLightColour());
    }

    private Object[] parametersToTestTrafficLight() {
        return new Object[] {
                new Object[] { new RedLight(), "Red", "Green" },
                new Object[] { new GreenLight(), "Green", "Yellow" },
                new Object[] { new YellowLight(), "Yellow", "Red" }
        };
    }
}
