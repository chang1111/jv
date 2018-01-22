package com.spring.exam08;

import java.util.List;

public interface IDaoPhone {
    ModelPhone getPhoneOne(String name);
    List<ModelPhone> getPhoneList();
    int insertPhone( ModelPhone phone );
    int insertPhoneList( List<ModelPhone> phones );    
}
