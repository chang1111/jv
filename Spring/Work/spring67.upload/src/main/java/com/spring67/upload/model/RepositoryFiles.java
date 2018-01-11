package com.spring67.upload.model;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

// 클라이언트에서 배열로 넘어오는 변수를 자바의 List로 변환하기 위한 클래스
@Repository
public class RepositoryFiles {
    
    // 필드명으로는 클라이언트에서 넘어오는 변수명
    // 즉, input 태그의 name 속성 값을 필드명으로 사용해야 한다.
    // <input type="file" name="files[0]" />
    
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
