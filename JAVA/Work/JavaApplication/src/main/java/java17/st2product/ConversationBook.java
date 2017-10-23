package java17.st2product;

public class ConversationBook extends Book {
    private String 언어명;

    public ConversationBook() {
        super();
    }

    public ConversationBook(int 고유식별자, String 상품설명, String 생산자, int 가격,
            int iSBN번호, String 저자, String 책제목, String 언어명) {
        super(고유식별자, 상품설명, 생산자, 가격, iSBN번호, 저자, 책제목);
        this.언어명 = 언어명;
    }

    public String get언어명() {
        return 언어명;
    }

    public void set언어명(String 언어명) {
        this.언어명 = 언어명;
    }

    @Override
    public String toString() {
        return super.toString() + "\n언어명>>" + 언어명;
    }
    
}
