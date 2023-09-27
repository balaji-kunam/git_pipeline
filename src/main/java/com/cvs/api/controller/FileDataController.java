package com.cvs.api.controller;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cvs.api.Entity.FileData;
import com.cvs.api.Service.FileDataService;
import java.util.List;

@RestController
@RequestMapping("/api/filedata")
public class FileDataController {
    private final FileDataService fileDataService;

    @Autowired
    public FileDataController(FileDataService fileDataService) {
        this.fileDataService = fileDataService;
    }

    @GetMapping("/getalldatas")
    public List<FileData> getAllFileData() {
        return fileDataService.getAllFileData();
    }

    @GetMapping("/getalldata/{id}")
    public FileData getFileDataById(@PathVariable Long id) {
        return fileDataService.getFileDataById(id);
    }

    @PostMapping("/postdata")
    public FileData createFileData(@RequestBody FileData fileData) {
        return fileDataService.createFileData(fileData);
    }

    @PutMapping("/update/{id}")
    public FileData updateFileData(@PathVariable Long id, @RequestBody FileData updatedFileData) {
        return fileDataService.updateFileData(id, updatedFileData);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFileData(@PathVariable Long id) {
        fileDataService.deleteFileData(id);
    }
}


 