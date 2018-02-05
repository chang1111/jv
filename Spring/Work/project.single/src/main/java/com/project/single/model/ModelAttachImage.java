package com.project.single.model;

import java.util.Arrays;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ModelAttachImage {
    private Integer attachimageno = null;  // `attachimageno` INT(10) NOT NULL,
    private String  fileName      = ""  ;  // `fileName` VARCHAR(50) NOT NULL,
    private Long    fileSize      = null;  // `fileSize` INT(11) NOT NULL,
    private String  contentType   = ""  ;  // `contentType` VARCHAR(30) NOT NULL,
    private byte[]  imageBytes    = null;  // `imageBytes` LONGBLOB NOT NULL,
    private String  imageBase64   = ""  ;  // `imageBase64` LONGTEXT NOT NULL,
    private Integer postno        = null;  // `postno` INT(10) NOT NULL,
    
    private CommonsMultipartFile image;

    public ModelAttachImage() {
        super();
    }

    public Integer getAttachimageno() {
        return attachimageno;
    }

    public void setAttachimageno(Integer attachimageno) {
        this.attachimageno = attachimageno;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public String getImageBase64() {
        return imageBase64;
    }

    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }

    public Integer getPostno() {
        return postno;
    }

    public void setPostno(Integer postno) {
        this.postno = postno;
    }
    public CommonsMultipartFile getImage() {
        return image;
    }
    public void setImage(CommonsMultipartFile image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ModelAttachImage [attachimageno=" + attachimageno
                + ", fileName=" + fileName + ", fileSize=" + fileSize
                + ", contentType=" + contentType + ", imageBytes="
                + Arrays.toString(imageBytes) + ", imageBase64=" + imageBase64
                + ", postno=" + postno + "]";
    }
    
    
}
