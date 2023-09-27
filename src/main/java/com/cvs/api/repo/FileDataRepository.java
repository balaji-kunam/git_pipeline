package com.cvs.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cvs.api.Entity.FileData;

public interface FileDataRepository extends JpaRepository<FileData, Long> {
}