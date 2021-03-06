package com.nuway.sensor.api.nuwaysensorapi.dao;

import com.nuway.sensor.api.nuwaysensorapi.model.DeviceStateInput;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DeviceStateDao {

    private Map<Integer, String> sensorState = new ConcurrentHashMap<>();

    public void saveState(DeviceStateInput deviceStateInput) {
        sensorState.put(deviceStateInput.getDeviceId(), deviceStateInput.getValue());
    }

    public String getState(Integer id) {
        return sensorState.getOrDefault(id, "STATE UNKNOWN");
    }
}
