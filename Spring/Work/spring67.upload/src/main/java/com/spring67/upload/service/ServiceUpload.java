package com.spring67.upload.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring67.upload.inf.IDaoUpload;
import com.spring67.upload.inf.IServiceUpload;
import com.spring67.upload.model.ModelUploadFile;

@Service
public class ServiceUpload implements IServiceUpload {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private IDaoUpload dao;

    @Override
    public List<ModelUploadFile> getUploadFile(ModelUploadFile file) {
        List<ModelUploadFile> result = null;
        try {
            result = dao.getUploadFile(file);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "getUploadFile " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int insertUploadFile(ModelUploadFile file) {
        int result = -1;
        try {
            result = dao.insertUploadFile(file);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "insertUploadFile " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int insertUploadFileList(List<ModelUploadFile> files) {
        int result = -1;
        try {
            result = dao.insertUploadFileList(files);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "insertUploadFileList " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int deleteUploadFile(ModelUploadFile file) {
        int result = -1;
        try {
            result = dao.deleteUploadFile(file);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error( "deleteUploadFile " + e.getMessage() );
        }
        return result;
    }
}
