package com.spring69.uploadimage.model;

import java.util.Arrays;

public class ModelUploadImage {
    private Integer uploadImageNo = null; //   `uploadImageNo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    private String  fileName      = ""  ; //   `fileName` VARCHAR(50) NOT NULL,
    private Long    fileSize      = null; //   `fileSize` INT(10) UNSIGNED NOT NULL,
    private String  contentType   = ""  ; //   `contentType` VARCHAR(30) NOT NULL,
    private byte[]  imageBytes    = null; //   `imageBytes` LONGBLOB NULL,
    private String  imageBase64   = ""  ; //   `imageBase64` LONGTEXT NULL,
    
    public ModelUploadImage() {
        super();
    }
    public Integer getUploadImageNo() {
        return uploadImageNo;
    }
    public void setUploadImageNo(Integer uploadImageNo) {
        this.uploadImageNo = uploadImageNo;
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
    @Override
    public String toString() {
        return "ModelUploadImage [uploadImageNo=" + uploadImageNo
                + ", fileName=" + fileName + ", fileSize=" + fileSize
                + ", contentType=" + contentType + ", imageBytes="
                + Arrays.toString(imageBytes) + ", imageBase64=" + imageBase64
                + "]";
    }
    
}
