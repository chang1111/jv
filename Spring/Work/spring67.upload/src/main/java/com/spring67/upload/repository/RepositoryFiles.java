package com.spring67.upload.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class RepositoryFiles {
    private List<MultipartFile> files;
    
    public List<MultipartFile> getFiles() {
        return files;
    }
    
    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
    
    public RepositoryFiles() {
        super();
    }
}
