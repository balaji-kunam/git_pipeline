package com.cvs.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FileDataControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllFileData() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/filedata/getalldatas")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    

    @Test
    public void testCreateFileData() throws Exception {
        // Create a JSON request body for creating a new FileData
        String requestBody = "{"
                + "\"fileName\": \"TestFile\","
                + "\"filePath\": \"/path/to/file\","
                + "\"receivedDT\": \"2023-09-28T10:00:00\","
                + "\"createdBy\": \"TestUser\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/filedata/postdata")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

   

    @Test
    public void testDeleteFileData() throws Exception {
        Long fileId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/filedata/delete/{id}", fileId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
