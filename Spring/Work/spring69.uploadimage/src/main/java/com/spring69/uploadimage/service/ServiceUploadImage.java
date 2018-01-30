package com.spring69.uploadimage.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring69.uploadimage.inf.IDaoUploadImage;
import com.spring69.uploadimage.inf.IServiceUploadImage;
import com.spring69.uploadimage.model.ModelUploadImage;

@Service
public class ServiceUploadImage implements IServiceUploadImage {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoUploadImage dao;

    @Override
    public ModelUploadImage getImageByte(int uploadImageNo) {
        ModelUploadImage result = null;
        try {
            result = dao.getImageByte(uploadImageNo);
        } catch (Exception e) {
            logger.error("getImageByte " + e.getMessage() );
        }
        return result;
    }

    @Override
    public int insertPhoto(ModelUploadImage image) {
        int result = -1;
        try {
            result = dao.insertPhoto(image);
        } catch (Exception e) {
            logger.error("insertPhoto " + e.getMessage() );
        }
        return result;
    }
}
