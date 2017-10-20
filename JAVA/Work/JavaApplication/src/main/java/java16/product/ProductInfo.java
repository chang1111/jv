package java16.product;

public class ProductInfo {
    public static void main(String[] args) {
        Product[] p = new Product[10];
        
        p[0] = new Book();
        p[1] = new CompactDisk();
        p[2] = new ConversationBook();
        p[3] = new Book();
        p[4] = new CompactDisk();
        p[5] = new ConversationBook();
        p[6] = new Book();
        p[7] = new CompactDisk();
        p[8] = new ConversationBook();
        p[9] = new Book();
        
        for (Product value : p) {
            System.out.println(value);
        }
    }
}
