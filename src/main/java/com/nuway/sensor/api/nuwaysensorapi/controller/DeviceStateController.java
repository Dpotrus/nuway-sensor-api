package com.nuway.sensor.api.nuwaysensorapi.controller;

import com.nuway.sensor.api.nuwaysensorapi.dao.DeviceStateDao;
import com.nuway.sensor.api.nuwaysensorapi.model.DeviceStateInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class DeviceStateController {

    private DeviceStateDao deviceStateDao;

    @Autowired
    public DeviceStateController(DeviceStateDao deviceStateDao) {
        this.deviceStateDao = deviceStateDao;
    }

    @PostMapping(value = "/state")
    public void addState(@RequestBody DeviceStateInput deviceStateInput) {
        deviceStateDao.saveState(deviceStateInput);
    }

}
