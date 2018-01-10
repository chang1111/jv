package com.spring67.upload.inf;

import com.spring67.upload.model.ModelUploadImage;

public interface IDaoUploadImage {
    ModelUploadImage getImageByte(int attachfileno);
    int insertPhoto(ModelUploadImage attachfile);
}
