package com.nuway.sensor.api.nuwaysensorapi.dao;

import com.nuway.sensor.api.nuwaysensorapi.model.Device;
import com.nuway.sensor.api.nuwaysensorapi.model.Room;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RoomDaoTest {

    private RoomDao roomDao;

    private DeviceDao deviceDao;

    @Before
    public void before() {
        deviceDao = Mockito.mock(DeviceDao.class);

        roomDao = new RoomDao(deviceDao);
    }

    @Test
    public void testAddRoom() {
        Room room = new Room();
        room.setId(1);
        room.setDomain("Stockholm");
        room.setName("Vardagsrummet");
        room.setDeviceList(new ArrayList<>());

        roomDao.addRoom(room);

        Room room1 = roomDao.getRoom(1);

        Assert.assertNotNull(room1);
        Assert.assertEquals(1, room1.getId());
        Assert.assertEquals("Vardagsrummet", room1.getName());
        Assert.assertEquals("Stockholm", room1.getDomain());
        Assert.assertTrue(room1.getDeviceList().isEmpty());
    }

    @Test
    public void testAddDevice() {
        Device device = new Device(1, "TEMP");

        Mockito.when(deviceDao.getById(Mockito.eq(1))).thenReturn(device);
        testAddRoom();

        roomDao.addDeviceToRoom(1, 1);

        Room room = roomDao.getRoom(1);

        List<Device> deviceList = room.getDeviceList();

        Assert.assertFalse(deviceList.isEmpty());
        Assert.assertEquals(1, deviceList.size());

        Device device1 = deviceList.get(0);

        Assert.assertEquals(device.getId(), device1.getId());
        Assert.assertEquals(device.getName(), device1.getName());
    }

}