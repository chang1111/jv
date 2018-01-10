package com.spring67.upload.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring67.upload.inf.IDaoUpload;
import com.spring67.upload.inf.IServiceUpload;
import com.spring67.upload.model.ModelUploadFile;

@Service("serviceupload")
public class ServiceUpload implements IServiceUpload {
    // SLF4J Logging
    private Logger     logger = LoggerFactory.getLogger(this.getClass());
    
    @Qualifier("daoupload")
    @Autowired
    private IDaoUpload uploaddao;
    
    @Override
    public List<ModelUploadFile> getUploadFile(ModelUploadFile file) {
        List<ModelUploadFile> result = null;
        try {
            result = uploaddao.getUploadFile(file);
        } catch (Exception e) {
            logger.error("getUploadFile " + e.getMessage());
        }
        return result;
    }
    
    @Override
    public int insertUploadFile(ModelUploadFile file) {
        int result = -1;
        try {
            result = uploaddao.insertUploadFile(file);
        } catch (Exception e) {
            logger.error("insertUploadFile " + e.getMessage());
        }
        return result;
    }
    
    @Override
    public int insertUploadFileList(List<ModelUploadFile> files) {
        int result = -1;
        try {
            result = uploaddao.insertUploadFileList(files);
        } catch (Exception e) {
            logger.error("insertUploadFileList " + e.getMessage());
        }
        return result;
    }
    
    @Override
    public int deleteUploadFile(ModelUploadFile file) {
        int result = -1;
        try {
            result = uploaddao.deleteUploadFile(file);
        } catch (Exception e) {
            logger.error("deleteUploadFile " + e.getMessage());
        }
        return result;
    }
}
