package com.nuway.sensor.api.nuwaysensorapi.dao;

import com.nuway.sensor.api.nuwaysensorapi.model.DeviceStateInput;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DeviceStateDaoTest {

    private DeviceStateDao deviceStateDao;

    @Before
    public void before() {
         deviceStateDao = new DeviceStateDao();
    }

    @Test
    public void testSaveDeviceState() {
        DeviceStateInput deviceStateInput = new DeviceStateInput();
        deviceStateInput.setDeviceId(1);
        deviceStateInput.setValue("34.2");

        deviceStateDao.saveState(deviceStateInput);

        String deviceStateInput1 = deviceStateDao.getState(1);
        Assert.assertEquals(deviceStateInput.getValue(), deviceStateInput1);
    }

    @Test
    public void testGetUnknownState() {
        String deviceState = deviceStateDao.getState(2);
        Assert.assertEquals("STATE UNKNOWN", deviceState);
    }

}
