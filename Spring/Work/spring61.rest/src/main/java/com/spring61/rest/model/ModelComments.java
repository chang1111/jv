package com.spring61.rest.model;

import java.util.Date;

public class ModelComments {
    Integer commentno   ; // NUMBER(10)     generated as identity 
    Integer articleno   ; // NUMBER(10)     NOT NULL     
    String  email       ; // VARCHAR2(60)  
    String  memo        ; // VARCHAR2(4000) NOT NULL    
    Date    regdate     ; // Date
    Boolean UseYN       ; // NUMBER(1)       DEFAULT 1 NOT NULL ENABLE
    String  InsertUID   ; // VARCHAR(40)  NULL                            
    Date    InsertDT    ; // Date         NULL
    String  UpdateUID   ; // VARCHAR(40)  NULL                            
    Date    UpdateDT    ; // Date         NULL

    
    public Integer getCommentno() {
        return commentno;
    }
    public void setCommentno(Integer commentno) {
        this.commentno = commentno;
    }
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
    public Date getRegdate() {
        return regdate;
    }
    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }
    public Boolean getUseYN() {
        return UseYN;
    }
    public void setUseYN(Boolean useYN) {
        UseYN = useYN;
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
    
    
    public ModelComments() {
        super();
    }
    
    public ModelComments(Integer articleno ) {
        super();
        this.articleno = articleno;
    }
    
    @Override
    public String toString() {
        return "ModelComments [commentno=" + commentno + ", articleno="
                + articleno + ", email=" + email + ", memo=" + memo
                + ", regdate=" + regdate + ", UseYN=" + UseYN + ", InsertUID="
                + InsertUID + ", InsertDT=" + InsertDT + ", UpdateUID="
                + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }
  
    
    
}
