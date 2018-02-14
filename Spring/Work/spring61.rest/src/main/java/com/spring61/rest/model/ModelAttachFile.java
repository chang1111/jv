package com.spring61.rest.model;

import java.util.Date;

public class ModelAttachFile {
    Integer attachfileno   ;
    String  filenameorig   ;
    String  filenametemp   ;
    String  filetype       ;
    Long    filesize       ;
    Integer articleno      ;
    Boolean UseYN          ; 
    String  InsertUID      ;     
    Date    InsertDT       ;
    String  UpdateUID      ;     
    Date    UpdateDT       ;
    
    public Integer getAttachfileno() {
        return attachfileno;
    }
    public void setAttachfileno(Integer attachfileno) {
        this.attachfileno = attachfileno;
    }
    public String getFilenameorig() {
        return filenameorig;
    }
    public void setFilenameorig(String filenameorig) {
        this.filenameorig = filenameorig;
    }
    public String getFilenametemp() {
        return filenametemp;
    }
    public void setFilenametemp(String filenametemp) {
        this.filenametemp = filenametemp;
    }
    public String getFiletype() {
        return filetype;
    }
    public void setFiletype(String filetype) {
        this.filetype = filetype;
    }
    public Long getFilesize() {
        return filesize;
    }
    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }
    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
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
    @Override
    public String toString() {
        return "ModelAttachFile [attachfileno=" + attachfileno
                + ", filenameorig=" + filenameorig + ", filenametemp="
                + filenametemp + ", filetype=" + filetype + ", filesize="
                + filesize + ", articleno=" + articleno + ", UseYN=" + UseYN
                + ", InsertUID=" + InsertUID + ", InsertDT=" + InsertDT
                + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }
    
    public ModelAttachFile() {
        super();
    }
    public ModelAttachFile(Integer attachfileno) {
        super();
        this.attachfileno = attachfileno;
    }    
    public ModelAttachFile(String filenameorig, String filetype, Long filesize, Integer articleno) {
        super();
        this.filenameorig = filenameorig;
        this.filetype = filetype;
        this.filesize = filesize;
        this.articleno = articleno;
    }
}
