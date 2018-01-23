package com.spring.exam08;

import java.util.List;

public interface IDaoPhone {
    ModelPhone getPhoneOne(String name);
    List<ModelPhone> getPhoneList(int start, int end);
    int getPhoneTotalRecord();
    int insertPhone( ModelPhone phone );
    int insertPhoneList( List<ModelPhone> phones );
}
