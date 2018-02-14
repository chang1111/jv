package example.com.prj.model;

import java.util.Date;

public class ModelComments {
    private Integer commentno = null;//commentno` INT(10) NOT NULL AUTO_INCREMENT,
    private Integer postno    = null;//`postno` INT(10) NOT NULL,
    private String  memo      = ""  ;//`memo` VARCHAR(4000) NOT NULL,
    private Date    regdate   = null;//`regdate` DATETIME NOT NULL,
    
    public ModelComments() {
        super();
    }

    public Integer getCommentno() {
        return commentno;
    }

    public void setCommentno(Integer commentno) {
        this.commentno = commentno;
    }

    public Integer getPostno() {
        return postno;
    }

    public void setPostno(Integer postno) {
        this.postno = postno;
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

    @Override
    public String toString() {
        return "ModelComments [commentno=" + commentno + ", postno=" + postno
                + ", memo=" + memo + ", regdate=" + regdate + "]";
    }
    
    
    
}
