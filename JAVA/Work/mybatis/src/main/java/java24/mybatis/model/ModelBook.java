package java24.mybatis.model;

import java.util.Date;

public class ModelBook {
    private Integer bookid    = null; // INT(11) NOT NULL AUTO_INCREMENT,
    private String  bookname  = ""  ; // VARCHAR(50) NULL DEFAULT NULL,
    private String  publisher = ""  ; // VARCHAR(40) NULL DEFAULT NULL,
    private String  year      = ""  ; // VARCHAR(10) NULL DEFAULT NULL,
    private Integer price     = null; // INT(11) NULL DEFAULT NULL,
    private Date    dtm       = null; // DATE NULL DEFAULT NULL,
    private Boolean use_yn    = null; // BIT(1) NULL DEFAULT NULL,
    private Integer authid    = null; // INT(11) NULL DEFAULT NULL,
    
    public ModelBook() {
        super();
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDtm() {
        return dtm;
    }

    public void setDtm(Date dtm) {
        this.dtm = dtm;
    }

    public Boolean getUse_yn() {
        return use_yn;
    }

    public void setUse_yn(Boolean use_yn) {
        this.use_yn = use_yn;
    }

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    @Override
    public String toString() {
        return "ModelBook [bookid=" + bookid + ", bookname=" + bookname
                + ", publisher=" + publisher + ", year=" + year + ", price="
                + price + ", dtm=" + dtm + ", use_yn=" + use_yn + ", authid="
                + authid + "]";
    }
    
    
}
