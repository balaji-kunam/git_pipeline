package com.cvs.api.Service;

import java.util.List;

import com.cvs.api.Entity.FileData;

public interface FileDataService {
    List<FileData> getAllFileData();
    FileData getFileDataById(Long id);
    FileData createFileData(FileData fileData);
    FileData updateFileData(Long id, FileData updatedFileData);
    void deleteFileData(Long id);
}