package com.spring.exam09;

import java.util.List;

public interface IDaoPhone {
    
    List<ModelPhone> getPhoneList();
    
    int insertPhone(ModelPhone phone);
    
}
