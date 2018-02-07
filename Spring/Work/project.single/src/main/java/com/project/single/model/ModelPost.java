package com.project.single.model;

import java.util.Date;
import java.util.List;

public class ModelPost {
    private Integer postno    = null;   //`postno` INT(10) NOT NULL AUTO_INCREMENT,
    private String  author    = ""  ;   //`author` VARCHAR(50) NOT NULL,
    private Date    regdate   = null;   //`regdate` DATETIME NOT NULL,
    private String  content   = ""  ;   //`content` MEDIUMTEXT NOT NULL,
    private Integer countgood = null;   //`countgood` INT(11) NOT NULL DEFAULT '0',
    private Integer countbad  = null;   //`countbad` INT(11) NOT NULL DEFAULT '0',
    
    private ModelAttachImage image = null;
    private Integer commentNum = null;
    private List<ModelComments> comment = null;
    
    public ModelPost() {
        super();
    }

    public Integer getPostno() {
        return postno;
    }

    public void setPostno(Integer postno) {
        this.postno = postno;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCountgood() {
        return countgood;
    }

    public void setCountgood(Integer countgood) {
        this.countgood = countgood;
    }

    public Integer getCountbad() {
        return countbad;
    }

    public void setCountbad(Integer countbad) {
        this.countbad = countbad;
    }

    public ModelAttachImage getImage() {
        return image;
    }

    public void setImage(ModelAttachImage image) {
        this.image = image;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public List<ModelComments> getComment() {
        return comment;
    }

    public void setComment(List<ModelComments> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ModelPost [postno=" + postno + ", author=" + author
                + ", regdate=" + regdate + ", content=" + content
                + ", countgood=" + countgood + ", countbad=" + countbad + "]";
    }
    
    
}
