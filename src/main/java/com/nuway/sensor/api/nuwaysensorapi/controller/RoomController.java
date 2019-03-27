package com.nuway.sensor.api.nuwaysensorapi.controller;

import com.nuway.sensor.api.nuwaysensorapi.dao.RoomDao;
import com.nuway.sensor.api.nuwaysensorapi.dao.DeviceStateDao;
import com.nuway.sensor.api.nuwaysensorapi.model.Device;
import com.nuway.sensor.api.nuwaysensorapi.model.DeviceState;
import com.nuway.sensor.api.nuwaysensorapi.model.Room;
import com.nuway.sensor.api.nuwaysensorapi.model.Snapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomDao roomDao;
    private DeviceStateDao deviceStateDao;

    @Autowired
    public RoomController(RoomDao roomDao, DeviceStateDao deviceStateDao) {
        this.roomDao = roomDao;
        this.deviceStateDao = deviceStateDao;
    }

    @PostMapping
    public void addRoom(@RequestBody Room room) {
        roomDao.addRoom(room);
    }

    @GetMapping("/{id}")
    public Snapshot getSnapshot(@PathVariable("id") Integer id) {
        Room room = roomDao.getRoom(id);
        List<Device> deviceList = room.getDeviceList();

        Snapshot snapshot = new Snapshot();

        List<DeviceState> deviceStates = new ArrayList<>();
        deviceList.forEach(device -> {
            String value = deviceStateDao.getState(device.getId());
            DeviceState deviceState = new DeviceState(device.getId(), device.getName(), value);
            deviceStates.add(deviceState);
        });

        snapshot.setRoomId(id);
        snapshot.setRoomName(room.getName());
        snapshot.setRoomDomain(room.getDomain());
        snapshot.setDeviceStates(deviceStates);
        return snapshot;
    }

    @PostMapping("{roomId}/device/{deviceId}")
    public void addDevice(@PathVariable("roomId") Integer roomId, @PathVariable("deviceId") Integer deviceId) {
        roomDao.addDeviceToRoom(roomId, deviceId);
    }

}