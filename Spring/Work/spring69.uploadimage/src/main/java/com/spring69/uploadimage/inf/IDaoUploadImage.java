package com.spring69.uploadimage.inf;

import com.spring69.uploadimage.model.ModelUploadImage;

public interface IDaoUploadImage {
    ModelUploadImage getImageByte(int uploadImageNo);
    int insertPhoto(ModelUploadImage image);
}
