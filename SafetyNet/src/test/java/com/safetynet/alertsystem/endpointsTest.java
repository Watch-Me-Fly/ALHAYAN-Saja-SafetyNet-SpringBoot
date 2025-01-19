package com.safetynet.alertsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class endpointsTest {

    @Autowired
    private MockMvc mockMvc;

    // ____ main endpoints
    @DisplayName("Main Person Endpoint")
    @Test
    void mainPersonEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/person"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @DisplayName("Main Station Endpoint")
    @Test
    void mainStationEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/firestation"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @DisplayName("Main Record Endpoint")
    @Test
    void mainRecordEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/medicalrecord"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
