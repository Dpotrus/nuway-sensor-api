package com.nuway.sensor.api.nuwaysensorapi.controller;

import com.nuway.sensor.api.nuwaysensorapi.dao.DeviceDao;
import com.nuway.sensor.api.nuwaysensorapi.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController {

    private DeviceDao deviceDao;

    @Autowired
    public DeviceController(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    @PostMapping
    public void addDevice(@RequestBody Device device) {
        deviceDao.addDevice(device);
    }
}
