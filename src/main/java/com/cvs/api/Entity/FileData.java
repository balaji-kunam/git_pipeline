package com.cvs.api.Entity;

 
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
 

@Entity
@Table(name = "at_source_articles")
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "filename")
    private String fileName;
    
    @Column(name = "filepath")
    private String filePath;
    
    @Column(name = "received_dt")
    private LocalDateTime receivedDT;
    
    @Column(name = "created_by")
    private String createdBy;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public LocalDateTime getReceivedDT() {
		return receivedDT;
	}
	public void setReceivedDT(LocalDateTime receivedDT) {
		this.receivedDT = receivedDT;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
    

    // Constructors, getters, setters
}