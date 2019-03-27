package com.nuway.sensor.api.nuwaysensorapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuway.sensor.api.nuwaysensorapi.NuwaySensorApiApplication;
import com.nuway.sensor.api.nuwaysensorapi.model.Device;
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
import org.springframework.web.util.NestedServletException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NuwaySensorApiApplication.class)
@AutoConfigureMockMvc
public class DeviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddDevice() throws Exception {
        Device device = new Device(1, "Termostat");

        ObjectMapper objectMapper = new ObjectMapper();

        String val = objectMapper.writeValueAsString(device);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/device")
                .content(val)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test(expected = NestedServletException.class)
    public void testAddDuplicateDevice() throws Exception {

        testAddDevice();

        Device device = new Device(1, "Termostat");

        ObjectMapper objectMapper = new ObjectMapper();

        String val = objectMapper.writeValueAsString(device);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/device")
                .content(val)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}