package com.spring67.upload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring67.upload.inf.IDaoUpload;
import com.spring67.upload.model.ModelUploadFile;

@Repository
public class DaoUpload implements IDaoUpload {
    
    @Autowired
    private SqlSession session;

    @Override
    public List<ModelUploadFile> getUploadFile(ModelUploadFile file) {
        return session.selectList("mapper.mysql.mapperUpload.getUploadFile", file);
    }

    @Override
    public int insertUploadFile(ModelUploadFile file) {
        session.insert("mapper.mysql.mapperUpload.insertUploadFile", file);
        return file.getUploadFileNo();
    }

    @Override
    public int insertUploadFileList(List<ModelUploadFile> files) {
        return session.insert("mapper.mysql.mapperUpload.insertUploadFileList", files);
    }

    @Override
    public int deleteUploadFile(ModelUploadFile file) {
        return session.delete("mapper.mysql.mapperUpload.deleteUploadFile", file);
    }
}
