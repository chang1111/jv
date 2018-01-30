package com.spring69.uploadimage.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring69.uploadimage.inf.IDaoUploadImage;
import com.spring69.uploadimage.model.ModelUploadImage;

@Repository
public class DaoUploadImage implements IDaoUploadImage {
    
    @Autowired
    SqlSession session;

    @Override
    public ModelUploadImage getImageByte(int uploadImageNo) {
        return session.selectOne("mapperUploadImage.getImageByte", uploadImageNo);
    }

    @Override
    public int insertPhoto(ModelUploadImage image) {
        return session.insert("mapperUploadImage.insertPhoto", image);
    }
}
