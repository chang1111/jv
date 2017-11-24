package board.model;

import java.util.Date;

public class ModelComments {
    private Integer commentno = null;  //   `commentno` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    private Integer articleno = null;  //   `articleno` INT(10) UNSIGNED NOT NULL,
    private String  email     = null;  //   `email` VARCHAR(60) NULL DEFAULT NULL,
    private String  memo      = null;  //   `memo` VARCHAR(4000) NULL DEFAULT NULL,
    private Date    regdate   = null;  //   `regdate` DATETIME NULL DEFAULT NULL,
    private Boolean UseYN     = null;  //   `UseYN` TINYINT(1) NULL DEFAULT '1',
    private String  InsertUID = null;  //   `InsertUID` VARCHAR(40) NULL DEFAULT NULL,
    private Date    InsertDT  = null;  //   `InsertDT` DATETIME NULL DEFAULT NULL,
    private String  UpdateUID = null;  //   `UpdateUID` VARCHAR(40) NULL DEFAULT NULL,
    private Date    UpdateDT  = null;  //   `UpdateDT` DATETIME NULL DEFAULT NULL,
    
    public ModelComments() {
        super();
    }

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

    @Override
    public String toString() {
        return "ModelComments [commentno=" + commentno + ", articleno="
                + articleno + ", email=" + email + ", memo=" + memo
                + ", regdate=" + regdate + ", UseYN=" + UseYN + ", InsertUID="
                + InsertUID + ", InsertDT=" + InsertDT + ", UpdateUID="
                + UpdateUID + ", UpdateDT=" + UpdateDT + "]";
    }
    
    
}
