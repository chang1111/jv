package model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelProduct {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private String name;
    private Integer price;
    
    public ModelProduct() {
        super();
    }

    public ModelProduct(String name, Integer price) {
        super();
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ModelProduct [name=" + name + ", price=" + price + "]";
    }
    
}
