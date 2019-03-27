package com.nuway.sensor.api.nuwaysensorapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nuway.sensor.api.nuwaysensorapi.NuwaySensorApiApplication;
import com.nuway.sensor.api.nuwaysensorapi.model.Room;
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

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NuwaySensorApiApplication.class)
@AutoConfigureMockMvc
public class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddRoom() throws Exception {
        Room room = new Room();
        room.setId(1);
        room.setName("Vardagsrummet");
        room.setDomain("Stockholm");
        room.setDeviceList(new ArrayList<>());

        ObjectMapper objectMapper = new ObjectMapper();

        String val = objectMapper.writeValueAsString(room);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/room")
                .content(val)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test(expected = NestedServletException.class)
    public void testDuplicateAdd() throws Exception {
        testAddRoom();

        Room room = new Room();
        room.setId(1);
        room.setName("Vardagsrummet");
        room.setDomain("Stockholm");
        room.setDeviceList(new ArrayList<>());

        ObjectMapper objectMapper = new ObjectMapper();

        String val = objectMapper.writeValueAsString(room);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/room")
                .content(val)
                .contentType(MediaType.APPLICATION_JSON_UTF8));
    }

}