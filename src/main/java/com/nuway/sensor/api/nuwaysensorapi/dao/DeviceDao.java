package com.nuway.sensor.api.nuwaysensorapi.dao;

import com.nuway.sensor.api.nuwaysensorapi.model.Device;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class DeviceDao {

    private Map<Integer, Device> allDevices = new ConcurrentHashMap<>();

    public void addDevice(Device device) {
        if (allDevices.containsKey(device.getId())) {
            throw new RuntimeException("Device with id: " + device.getId() + " already exists.");
        } else {
            allDevices.put(device.getId(), device);
        }
    }

    Device getById(Integer id) {
        if (allDevices.containsKey(id)) {
            return allDevices.get(id);
        }
        throw new RuntimeException("Device with id: " + id + " does not exist.");
    }
}