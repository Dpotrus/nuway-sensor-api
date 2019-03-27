package com.nuway.sensor.api.nuwaysensorapi.model;

import java.util.List;

public class Snapshot {
    private Integer roomId;
    private String roomName;
    private String roomDomain;
    private List<DeviceState> deviceStates;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomDomain() {
        return roomDomain;
    }

    public void setRoomDomain(String roomDomain) {
        this.roomDomain = roomDomain;
    }

    public List<DeviceState> getDeviceStates() {
        return deviceStates;
    }

    public void setDeviceStates(List<DeviceState> deviceStates) {
        this.deviceStates = deviceStates;
    }
}
