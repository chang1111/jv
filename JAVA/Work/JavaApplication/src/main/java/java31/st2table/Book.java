package java31.st2table;

public class Book {
    private Integer bookid   = null;       //    bookid    int not null auto_increment primary key
    private String  bookname  = "";         //  , bookname  varchar(50)
    private String  publisher = "";         //  , publisher varchar(40)
    private String  year      = "";         //  , year      varchar(10)
    private Integer  price     = null;       //  , price     int
    private Boolean use_yn   = null;       //  , use_yn    bit
    private Integer authid   = null;       //  , authid    int
    
    public Book() {
        super();
    }

    public Book(Integer bookid, String bookname, String publisher, String year,
            Integer price, Boolean use_yn, Integer authid) {
        super();
        this.bookid = bookid;
        this.bookname = bookname;
        this.publisher = publisher;
        this.year = year;
        this.price = price;
        this.use_yn = use_yn;
        this.authid = authid;
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
        return "Book [bookid=" + bookid + ", bookname=" + bookname
                + ", publisher=" + publisher + ", year=" + year + ", price="
                + price + ", use_yn=" + use_yn + ", authid="
                + authid + "]";
    }
    
    
}
