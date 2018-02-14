package com.example.bbs.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ModelUser implements Parcelable {
    
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

    @Override
    public String toString() {
        return "ModelUser [userno=" + userno + ", userid=" + userid + ", email="
                + email + ", passwd=" + passwd + ", name=" + name + ", mobile="
                + mobile + ", retireYN=" + retireYN + ", InsertUID=" + InsertUID
                + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID
                + ", UpdateDT=" + UpdateDT + "]";
    }

    public ModelUser() {
        super();
    }

    protected ModelUser(Parcel in) {
        if (in.readByte() == 0) {
            userno = null;
        } else {
            userno = in.readInt();
        }
        userid = in.readString();
        email = in.readString();
        passwd = in.readString();
        name = in.readString();
        mobile = in.readString();
        byte tmpRetireYN = in.readByte();
        retireYN = tmpRetireYN == 0 ? null : tmpRetireYN == 1;
        InsertUID = in.readString();
        UpdateUID = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (userno == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(userno);
        }
        dest.writeString(userid);
        dest.writeString(email);
        dest.writeString(passwd);
        dest.writeString(name);
        dest.writeString(mobile);
        dest.writeByte((byte) (retireYN == null ? 0 : retireYN ? 1 : 2));
        dest.writeString(InsertUID);
        dest.writeString(UpdateUID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelUser> CREATOR = new Creator<ModelUser>() {
        @Override
        public ModelUser createFromParcel(Parcel in) {
            return new ModelUser(in);
        }

        @Override
        public ModelUser[] newArray(int size) {
            return new ModelUser[size];
        }
    };

}
