package com.nuway.sensor.api.nuwaysensorapi.dao;

import com.nuway.sensor.api.nuwaysensorapi.model.Device;
import com.nuway.sensor.api.nuwaysensorapi.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RoomDao {

    private Map<Integer, Room> rooms = new HashMap<>();
    private DeviceDao deviceDao;

    @Autowired
    public RoomDao(DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    public void addRoom(Room room) {
        if (rooms.containsKey(room.getId())) {
            throw new RuntimeException("Room already exists!");
        } else {
            rooms.put(room.getId(), room);
        }
    }

    public void addDeviceToRoom(Integer roomId, Integer deviceId) {
        Device device = deviceDao.getById(deviceId);
        Room room = getRoom(roomId);
        room.getDeviceList().add(device);
    }

    public Room getRoom(Integer id) {
        if (rooms.containsKey(id)) {
            return rooms.get(id);
        } else {
            throw new RuntimeException("Room with id: " + id + " does not exist.");
        }
    }
}
