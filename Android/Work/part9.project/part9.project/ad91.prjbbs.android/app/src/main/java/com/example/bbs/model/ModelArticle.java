package com.example.bbs.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class ModelArticle implements Parcelable {
    
    Integer articleno ;
    String  boardcd   ;
    String  title     ;
    String  content   ;
    String  email     ;
    Integer hit       ;
    Date    regdate   ;
    Boolean UseYN     ;
    String  InsertUID ;     
    Date    InsertDT  ;
    String  UpdateUID ;     
    Date    UpdateDT  ;
    
    //
    Integer attachFileNum;
    Integer commentNum;

    public Integer getArticleno() {
        return articleno;
    }
    public void setArticleno(Integer articleno) {
        this.articleno = articleno;
    }
    public String getBoardcd() {
        return boardcd;
    }
    public void setBoardcd(String boardcd) {
        this.boardcd = boardcd;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getHit() {
        return hit;
    }
    public void setHit(Integer hit) {
        this.hit = hit;
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
    public Integer getAttachFileNum() {
        return attachFileNum;
    }
    public void setAttachFileNum(Integer attachFileNum) {
        this.attachFileNum = attachFileNum;
    }
    public Integer getCommentNum() {
        return commentNum;
    }
    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    
    @Override
    public String toString() {
        return "ModelArticle [articleno=" + articleno + ", boardcd=" + boardcd
                + ", title=" + title + ", content=" + content + ", email="
                + email + ", hit=" + hit + ", regdate=" + regdate + ", UseYN="
                + UseYN + ", InsertUID=" + InsertUID + ", InsertDT=" + InsertDT
                + ", UpdateUID=" + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }



    public ModelArticle() {
        super();
    }
    public ModelArticle(Integer articleno) {
        super();
        this.articleno = articleno;
    }

    protected ModelArticle(Parcel in) {
        if (in.readByte() == 0) {
            articleno = null;
        } else {
            articleno = in.readInt();
        }
        boardcd = in.readString();
        title = in.readString();
        content = in.readString();
        email = in.readString();
        if (in.readByte() == 0) {
            hit = null;
        } else {
            hit = in.readInt();
        }
        byte tmpUseYN = in.readByte();
        UseYN = tmpUseYN == 0 ? null : tmpUseYN == 1;
        InsertUID = in.readString();
        UpdateUID = in.readString();
        if (in.readByte() == 0) {
            attachFileNum = null;
        } else {
            attachFileNum = in.readInt();
        }
        if (in.readByte() == 0) {
            commentNum = null;
        } else {
            commentNum = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (articleno == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(articleno);
        }
        dest.writeString(boardcd);
        dest.writeString(title);
        dest.writeString(content);
        dest.writeString(email);
        if (hit == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(hit);
        }
        dest.writeByte((byte) (UseYN == null ? 0 : UseYN ? 1 : 2));
        dest.writeString(InsertUID);
        dest.writeString(UpdateUID);
        if (attachFileNum == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(attachFileNum);
        }
        if (commentNum == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(commentNum);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ModelArticle> CREATOR = new Creator<ModelArticle>() {
        @Override
        public ModelArticle createFromParcel(Parcel in) {
            return new ModelArticle(in);
        }

        @Override
        public ModelArticle[] newArray(int size) {
            return new ModelArticle[size];
        }
    };

}
