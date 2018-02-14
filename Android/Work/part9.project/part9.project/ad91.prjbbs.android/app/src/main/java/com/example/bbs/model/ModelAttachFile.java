package com.example.bbs.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ModelAttachFile implements Parcelable {
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

    protected ModelAttachFile(Parcel in) {
        if (in.readByte() == 0) {
            attachfileno = null;
        } else {
            attachfileno = in.readInt();
        }
        filenameorig = in.readString();
        filenametemp = in.readString();
        filetype = in.readString();
        if (in.readByte() == 0) {
            filesize = null;
        } else {
            filesize = in.readLong();
        }
        if (in.readByte() == 0) {
            articleno = null;
        } else {
            articleno = in.readInt();
        }
        byte tmpUseYN = in.readByte();
        UseYN = tmpUseYN == 0 ? null : tmpUseYN == 1;
        InsertUID = in.readString();
        UpdateUID = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (attachfileno == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(attachfileno);
        }
        dest.writeString(filenameorig);
        dest.writeString(filenametemp);
        dest.writeString(filetype);
        if (filesize == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(filesize);
        }
        if (articleno == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(articleno);
        }
        dest.writeByte((byte) (UseYN == null ? 0 : UseYN ? 1 : 2));
        dest.writeString(InsertUID);
        dest.writeString(UpdateUID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelAttachFile> CREATOR = new Creator<ModelAttachFile>() {
        @Override
        public ModelAttachFile createFromParcel(Parcel in) {
            return new ModelAttachFile(in);
        }

        @Override
        public ModelAttachFile[] newArray(int size) {
            return new ModelAttachFile[size];
        }
    };
}
