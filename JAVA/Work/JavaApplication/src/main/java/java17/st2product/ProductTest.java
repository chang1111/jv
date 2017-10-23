package java17.st2product;

public class ProductTest {
    
    public static void main(String[] args) {
        Product[] p = new Product[10];
        p[0] = new Product();
        p[1] = new Book();
        p[2] = new CompactDisc();
        p[3] = new ConversationBook();
        p[4] = new Book();
        p[5] = new CompactDisc();
        p[6] = new ConversationBook();
        p[7] = new Book();
        p[8] = new CompactDisc();
        p[9] = new ConversationBook();
        
        for (Product i : p)
            System.out.println(i);
        
    }
    
}
