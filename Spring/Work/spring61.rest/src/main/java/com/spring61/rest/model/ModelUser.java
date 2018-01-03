package com.spring61.rest.model;

import java.util.Date;

public class ModelUser {
    
    Integer  userno      ; // NUMBER(10)      generated as identity
    String   userid      ; // VARCHAR2( 50)   NOT NULL
    String   email       ; // VARCHAR2(100)   NOT NULL
    String   passwd      ; // VARCHAR(  30)    
    String   name        ; // VARCHAR2( 30)    
    String   mobile      ; // VARCHAR(20)        
    Boolean  retireYN    ; // NUMBER(1)       DEFAULT 1 NOT NULL ENABLE     

    String   InsertUID   ; // VARCHAR(40)     NULL                            
    Date     InsertDT    ; // Date            NULL
    String   UpdateUID   ; // VARCHAR(40)     NULL                            
    Date     UpdateDT    ; // Date            NULL
    public Integer getUserno() {
        return userno;
    }
    public void setUserno(Integer userno) {
        this.userno = userno;
    }
    public String getUserid() {
        return userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Boolean getRetireYN() {
        return retireYN;
    }
    public void setRetireYN(Boolean retireYN) {
        this.retireYN = retireYN;
    }
    public String getInsertUID() {
        return InsertUID;
    }
    public void setInsertUID(String insertUID) {
        InsertUID = insertUID;
    }
    public Date getInsertDT() {
        return InsertDT;
    }
    public void setInsertDT(Date insertDT) {
        InsertDT = insertDT;
    }
    public String getUpdateUID() {
        return UpdateUID;
    }
    public void setUpdateUID(String updateUID) {
        UpdateUID = updateUID;
    }
    public Date getUpdateDT() {
        return UpdateDT;
    }
    public void setUpdateDT(Date updateDT) {
        UpdateDT = updateDT;
    }
    
    
    public ModelUser() {
        super();
    }
    
    @Override
    public String toString() {
        return "ModelUser [userno=" + userno + ", userid=" + userid + ", email="
                + email + ", passwd=" + passwd + ", name=" + name + ", mobile="
                + mobile + ", retireYN=" + retireYN + ", InsertUID=" + InsertUID
                + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID
                + ", UpdateDT=" + UpdateDT + "]";
    }
    
}
