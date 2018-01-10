package com.spring67.upload.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring67.upload.inf.IDaoUploadImage;
import com.spring67.upload.model.ModelUploadImage;

@Repository("daouploadimage")
public class DaoUploadImage implements IDaoUploadImage {
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    public int insertPhoto(ModelUploadImage imageinfo) {
        /*
         * // Oracle 인 경우 Map<String, Object> map = new HashMap<String, Object>(); map.put("fileinfo" , imageinfo);
         * map.put("result", null); session.insert("mapper.mapperUpload.insertPhoto", map); int result =
         * map.get("result") != null ? (int) map.get("result") : -1; return result;
         */
        // mysql 인 경우
        session.insert("mapper.mapperUploadImage.insertPhoto", imageinfo);
        return imageinfo.getUploadImageNo();
    }
    
    public ModelUploadImage getImageByte(int attachfileno) {
        return session.selectOne("mapper.mapperUploadImage.getImageByte",
                attachfileno);
    }
}
