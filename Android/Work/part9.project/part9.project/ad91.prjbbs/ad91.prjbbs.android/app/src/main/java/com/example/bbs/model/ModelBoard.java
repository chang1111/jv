package com.example.bbs.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ModelBoard implements Parcelable {

    String  boardcd    ; // VARCHAR2(20)    NOT NULL ENABLE
    String  boardnm    ; // VARCHAR2(40)    NOT NULL ENABLE
    Boolean UseYN      ; // NUMBER(1)       DEFAULT 1 NOT NULL ENABLE
    String  InsertUID  ; // VARCHAR(40)     NULL                            
    Date    InsertDT   ; // Date            NULL
    String  UpdateUID  ; // VARCHAR(40)     NULL                            
    Date    UpdateDT   ; // Date            NULL

    public String getBoardcd() {
        return boardcd;
    }
    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }
    public String getBoardnm() {
        return boardnm;
    }
    public void setBoardnm(String boardnm) {
        this.boardnm = boardnm;
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
        return "ModelBoard [boardcd=" + boardcd + ", boardnm=" + boardnm
                + ", UseYN=" + UseYN + ", InsertUID=" + InsertUID
                + ", InsertDT=" + InsertDT + ", UpdateUID=" + UpdateUID
                + ", UpdateDT=" + UpdateDT + "]";
    }

    public ModelBoard() {
        super();
    }

    protected ModelBoard(Parcel in) {
        boardcd = in.readString();
        boardnm = in.readString();
        byte tmpUseYN = in.readByte();
        UseYN = tmpUseYN == 0 ? null : tmpUseYN == 1;
        InsertUID = in.readString();
        UpdateUID = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(boardcd);
        dest.writeString(boardnm);
        dest.writeByte((byte) (UseYN == null ? 0 : UseYN ? 1 : 2));
        dest.writeString(InsertUID);
        dest.writeString(UpdateUID);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelBoard> CREATOR = new Creator<ModelBoard>() {
        @Override
        public ModelBoard createFromParcel(Parcel in) {
            return new ModelBoard(in);
        }

        @Override
        public ModelBoard[] newArray(int size) {
            return new ModelBoard[size];
        }
    };



}
