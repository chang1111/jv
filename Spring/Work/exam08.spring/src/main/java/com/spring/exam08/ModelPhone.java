package com.spring.exam08;

public class ModelPhone {
    private String  name        = ""  ;   //`name` VARCHAR(50) NOT NULL,
    private String  manufacturer = ""  ;   //`manufacturer` VARCHAR(30) NOT NULL,
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ModelPhone [name=" + name + ", manufacturer=" + manufacturer
                + ", price=" + price + "]";
    }
    
}
