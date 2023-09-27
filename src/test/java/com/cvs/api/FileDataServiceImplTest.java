package com.cvs.api;

 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cvs.api.Entity.FileData;
import com.cvs.api.Service.impl.FileDataServiceImpl;
import com.cvs.api.repo.FileDataRepository;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FileDataServiceImplTest {

    @Mock
    private FileDataRepository fileDataRepository;

    private FileDataServiceImpl fileDataService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        fileDataService = new FileDataServiceImpl(fileDataRepository);
    }

    @Test
    public void testGetFileDataById() {
        Long fileId = 1L;
        FileData fileData = new FileData();
        fileData.setId(fileId);

        when(fileDataRepository.findById(fileId)).thenReturn(Optional.of(fileData));

        FileData result = fileDataService.getFileDataById(fileId);

        assertNotNull(result);
        assertEquals(fileId, result.getId());
    }

    @Test
    public void testCreateFileData() {
        FileData fileDataToCreate = new FileData();
        fileDataToCreate.setFileName("TestFile");
        fileDataToCreate.setFilePath("/path/to/file");
        fileDataToCreate.setReceivedDT(LocalDateTime.now());
        fileDataToCreate.setCreatedBy("TestUser");

        when(fileDataRepository.save(fileDataToCreate)).thenReturn(fileDataToCreate);

        FileData createdFileData = fileDataService.createFileData(fileDataToCreate);

        assertNotNull(createdFileData);
        assertEquals("TestFile", createdFileData.getFileName());
        // Add more assertions for other fields as needed
    }

    @Test
    public void testUpdateFileData() {
        Long fileId = 1L;
        FileData existingFileData = new FileData();
        existingFileData.setId(fileId);
        existingFileData.setFileName("ExistingFile");

        FileData updatedFileData = new FileData();
        updatedFileData.setId(fileId);
        updatedFileData.setFileName("UpdatedFile");

        when(fileDataRepository.findById(fileId)).thenReturn(Optional.of(existingFileData));
        when(fileDataRepository.save(existingFileData)).thenReturn(updatedFileData);

        FileData result = fileDataService.updateFileData(fileId, updatedFileData);

        assertNotNull(result);
        assertEquals("UpdatedFile", result.getFileName());
        // Add more assertions for other fields as needed
    }

    @Test
    public void testDeleteFileData() {
        Long fileId = 1L;

        // Mock the repository's deleteById method
        doNothing().when(fileDataRepository).deleteById(fileId);

        // Call the service method
        fileDataService.deleteFileData(fileId);

        // Verify that the deleteById method was called once
        verify(fileDataRepository, times(1)).deleteById(fileId);
    }
}
