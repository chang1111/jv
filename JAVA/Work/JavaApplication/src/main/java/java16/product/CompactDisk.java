package java16.product;

public class CompactDisk extends Product {
    private String 앨범제목;
    private String 가수이름;
    
    public CompactDisk() {
        
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
        return "CompactDisk [앨범제목=" + 앨범제목 + ", 가수이름=" + 가수이름 + ", toString()="
                + super.toString() + "]";
    }

}
