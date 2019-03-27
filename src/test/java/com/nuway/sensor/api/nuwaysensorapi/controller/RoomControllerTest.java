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
        Room room1 = new Room();
        room1.setId(1);
        room1.setName("Vardagsrummet");
        room1.setDomain("Stockholm");
        room1.setDeviceList(new ArrayList<>());

        ObjectMapper objectMapper = new ObjectMapper();

        String val1 = objectMapper.writeValueAsString(room1);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/room")
                .content(val1)
                .contentType(MediaType.APPLICATION_JSON_UTF8));

        Room room2 = new Room();
        room2.setId(1);
        room2.setName("Vardagsrummet");
        room2.setDomain("Stockholm");
        room2.setDeviceList(new ArrayList<>());

        String val2 = objectMapper.writeValueAsString(room2);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/room")
                .content(val2)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}