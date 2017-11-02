package java17.st2product;

public class Product {
    private int 고유식별자;
    private String 상품설명;
    private String 생산자;
    private int 가격;
    
    public Product() {
        super();
    }

    public Product(int 고유식별자, String 상품설명, String 생산자, int 가격) {
        super();
        this.고유식별자 = 고유식별자;
        this.상품설명 = 상품설명;
        this.생산자 = 생산자;
        this.가격 = 가격;
    }

    public int get고유식별자() {
        return 고유식별자;
    }

    public void set고유식별자(int 고유식별자) {
        this.고유식별자 = 고유식별자;
    }

    public String get상품설명() {
        return 상품설명;
    }

    public void set상품설명(String 상품설명) {
        this.상품설명 = 상품설명;
    }

    public String get생산자() {
        return 생산자;
    }

    public void set생산자(String 생산자) {
        this.생산자 = 생산자;
    }

    public int get가격() {
        return 가격;
    }

    public void set가격(int 가격) {
        this.가격 = 가격;
    }

    @Override
    public String toString() {
        return "고유식별자>>" + 고유식별자 + "\n상품설명>>" + 상품설명 + "\n생산자>>" + 생산자 + "\n가격>>" + 가격 + "\n";
    }
    
}
