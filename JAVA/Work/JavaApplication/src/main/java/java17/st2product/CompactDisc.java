package java17.st2product;

public class CompactDisc extends Product {
    private String 앨범제목;
    private String 가수이름;
    
    public CompactDisc() {
        super();
    }

    public CompactDisc(int 고유식별자, String 상품설명, String 생산자, int 가격, String 앨범제목,
            String 가수이름) {
        super(고유식별자, 상품설명, 생산자, 가격);
        this.앨범제목 = 앨범제목;
        this.가수이름 = 가수이름;
    }

    public String get앨범제목() {
        return 앨범제목;
    }

    public void set앨범제목(String 앨범제목) {
        this.앨범제목 = 앨범제목;
    }

    public String get가수이름() {
        return 가수이름;
    }

    public void set가수이름(String 가수이름) {
        this.가수이름 = 가수이름;
    }

    @Override
    public String toString() {
        return super.toString() + "\n앨범제목>>" + 앨범제목 + "\n가수이름>>" + 가수이름;
    }
    
}
