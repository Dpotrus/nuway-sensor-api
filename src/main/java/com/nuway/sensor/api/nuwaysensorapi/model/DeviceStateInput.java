package com.nuway.sensor.api.nuwaysensorapi.model;

public class DeviceStateInput {

    private int deviceId;
    private String value;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
