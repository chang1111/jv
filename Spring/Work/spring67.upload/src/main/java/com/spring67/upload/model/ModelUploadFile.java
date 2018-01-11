package com.spring67.upload.model;

public class ModelUploadFile {
    private Integer uploadFileNo = null ; // `uploadFileNo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    private String  fileNameOrig = ""   ; // `fileNameOrig` VARCHAR(100) NOT NULL,
    private String  fileNameTemp = ""   ; // `fileNameTemp` VARCHAR(100) NOT NULL,
    private Long    fileSize     = null ; // `fileSize` INT(10) UNSIGNED NOT NULL,
    private String  contentType  = ""   ; // `contentType` VARCHAR(30) NOT NULL,
    
    // getter & setter
    public Integer getUploadFileNo() {
        return uploadFileNo;
    }
    
    public void setUploadFileNo(Integer uploadFileNo) {
        this.uploadFileNo = uploadFileNo;
    }
    
    public String getFileNameOrig() {
        return fileNameOrig;
    }
    
    public void setFileNameOrig(String fileNameOrig) {
        this.fileNameOrig = fileNameOrig;
    }
    
    public String getFileNameTemp() {
        return fileNameTemp;
    }
    
    public void setFileNameTemp(String fileNameTemp) {
        this.fileNameTemp = fileNameTemp;
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
    
    // toString
    @Override
    public String toString() {
        return "ModelUploadFile [uploadFileNo=" + uploadFileNo
                + ", fileNameOrig=" + fileNameOrig + ", fileNameTemp="
                + fileNameTemp + ", fileSize=" + fileSize + ", contentType="
                + contentType + "]";
    }
    
    // constructor
    public ModelUploadFile() {
        super();
    }
}
