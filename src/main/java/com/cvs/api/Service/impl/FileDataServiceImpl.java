package com.cvs.api.Service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvs.api.Entity.FileData;
import com.cvs.api.Service.FileDataService;
import com.cvs.api.repo.FileDataRepository;

import java.util.List;

@Service
public class FileDataServiceImpl implements FileDataService {
    private final FileDataRepository fileDataRepository;

    @Autowired
    public FileDataServiceImpl(FileDataRepository fileDataRepository) {
        this.fileDataRepository = fileDataRepository;
    }

    @Override
    public List<FileData> getAllFileData() {
        return fileDataRepository.findAll();
    }

    @Override
    public FileData getFileDataById(Long id) {
        return fileDataRepository.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException("FileData", "id", id));
    }

    @Override
    public FileData createFileData(FileData fileData) {
        return fileDataRepository.save(fileData);
    }

    @Override
    public FileData updateFileData(Long id, FileData updatedFileData) {
        return fileDataRepository.findById(id).map(fileData -> {
            fileData.setFileName(updatedFileData.getFileName());
            fileData.setFilePath(updatedFileData.getFilePath());
            fileData.setReceivedDT(updatedFileData.getReceivedDT());
            fileData.setCreatedBy(updatedFileData.getCreatedBy());
            return fileDataRepository.save(fileData);
        }).orElseThrow(() -> new ResourceNotFoundException("FileData", "id", id));
    }

    @Override
    public void deleteFileData(Long id) {
        fileDataRepository.deleteById(id);
    }
}