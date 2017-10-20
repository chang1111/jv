package java16.product;

public class ConversationBook extends Book {
    private String 언어명;
    
    public ConversationBook() {
        
    }

    public String get언어명() {
        return 언어명;
    }

    public void set언어명(String 언어명) {
        this.언어명 = 언어명;
    }

    @Override
    public String toString() {
        return "ConversationBook [언어명=" + 언어명 + ", toString()="
                + super.toString() + "]";
    }

}
