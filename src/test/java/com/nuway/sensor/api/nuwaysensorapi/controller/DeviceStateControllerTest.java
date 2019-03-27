package com.nuway.sensor.api.nuwaysensorapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuway.sensor.api.nuwaysensorapi.NuwaySensorApiApplication;
import com.nuway.sensor.api.nuwaysensorapi.model.DeviceStateInput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NuwaySensorApiApplication.class)
@AutoConfigureMockMvc
public class DeviceStateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddDeviceState() throws Exception {
        DeviceStateInput deviceStateInput = new DeviceStateInput();
        deviceStateInput.setDeviceId(1);
        deviceStateInput.setValue("38.2");

        ObjectMapper objectMapper = new ObjectMapper();

        String val = objectMapper.writeValueAsString(deviceStateInput);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/device-state")
                .content(val)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
