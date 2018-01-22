package com.spring.exam08;

public class ModelPhone {
    private String  name        = ""  ;   //`name` VARCHAR(50) NOT NULL,
    private String  manufacture = ""  ;   //`manufacturer` VARCHAR(30) NOT NULL,
    private Integer price       = null;   //`price` INT(11) NOT NULL
    
    public ModelPhone() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ModelPhone [name=" + name + ", manufacture=" + manufacture
                + ", price=" + price + "]";
    }
    
}
