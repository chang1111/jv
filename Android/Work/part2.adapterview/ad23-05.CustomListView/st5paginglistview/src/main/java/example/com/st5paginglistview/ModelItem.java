package example.com.st5paginglistview;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-01-08.
 */

public class ModelItem {
    private Drawable image;
    private String name;
    private String price;
    private String description;

    public ModelItem() {
    }

    public ModelItem(Drawable image, String name, String price, String description) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
