package com.traffic.sample.traffic.state;

public class TrafficLights {

    private LightState lightState;

    public TrafficLights(LightState lightState) {
        this.lightState = lightState;
    }

    public String getCurrentLightColour() {
        return this.lightState.getLightState();
    }

    public void changeState() {
        this.lightState.changeState(this);
    }

    public LightState getLightState() {
        return lightState;
    }

    public void setLightState(final LightState lightState) {
        this.lightState = lightState;
    }
}
