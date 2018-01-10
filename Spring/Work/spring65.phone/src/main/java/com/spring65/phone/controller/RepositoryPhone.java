package com.spring65.phone.controller;

import java.util.List;

import com.spring65.phone.model.ModelPhone;

public class RepositoryPhone {
    private List<ModelPhone> phoneItems;

    public RepositoryPhone() {
        super();
    }

    public List<ModelPhone> getPhoneItems() {
        return phoneItems;
    }
    
    public void setPhoneItems(List<ModelPhone> phones) {
        this.phoneItems = phones;
    }

    @Override
    public String toString() {
        return "RepositoryPhone [phones=" + phoneItems + "]";
    }
    
    
}
