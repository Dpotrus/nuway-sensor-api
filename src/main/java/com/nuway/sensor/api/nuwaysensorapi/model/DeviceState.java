package com.nuway.sensor.api.nuwaysensorapi.model;

public class DeviceState {

    private Integer deviceId;
    private String deviceName;
    private String value;

    public DeviceState(Integer deviceId, String deviceName, String value) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.value = value;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}