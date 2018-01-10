package com.spring67.upload.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring67.upload.inf.IDaoUploadImage;
import com.spring67.upload.inf.IServiceUploadImage;
import com.spring67.upload.model.ModelUploadImage;

@Service("svruploadimage")
public class ServiceUploadImage implements IServiceUploadImage {
    // SLF4J Logging
    private Logger     logger = LoggerFactory.getLogger(this.getClass());
    
    @Qualifier("daouploadimage")
    @Autowired
    private IDaoUploadImage uploadimagedao;
    
    @Override
    public int insertPhoto(ModelUploadImage attachfile) {
        int result = -1;
        try {
            result = uploadimagedao.insertPhoto(attachfile);
        } catch (Exception e) {
            logger.error("insertPhoto " + e.getMessage());
        }
        return result;
    }
    
    @Override
    public ModelUploadImage getImageByte(int attachfileno) {
        ModelUploadImage result = null;
        try {
            result = uploadimagedao.getImageByte(attachfileno);
        } catch (Exception e) {
            logger.error("getImageByte " + e.getMessage());
        }
        return result;
    }
}
