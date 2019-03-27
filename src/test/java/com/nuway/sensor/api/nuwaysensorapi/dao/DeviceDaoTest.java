package com.nuway.sensor.api.nuwaysensorapi.dao;

import com.nuway.sensor.api.nuwaysensorapi.model.Device;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

public class DeviceDaoTest {

    private DeviceDao deviceDao;

    @Before
    public void before() {
        deviceDao = new DeviceDao();
    }

    @Test
    public void testAddDevice() {
        Device device = new Device(1, "Thermostat");
        deviceDao.addDevice(device);

        Device device1 = deviceDao.getById(1);
        Assert.assertEquals(device1.getId(), device.getId());
        Assert.assertEquals(device1.getName(), device.getName());
    }

    @Test(expected = RuntimeException.class)
    public void testAddDuplicateDevice() throws Exception {
        testAddDevice();
        Device device = new Device(1, "Thermostat");
        deviceDao.addDevice(device);
    }


    @Test(expected = RuntimeException.class)
    public void testGetUnknownDevice() throws Exception {
        deviceDao.getById(5);
    }
}
