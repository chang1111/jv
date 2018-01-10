package example.com.simplemultitype;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-01-10.
 */

public class ModelItem {
    // View type을 위한 필드 : 0 or 1
    private int type;

    public int getType() {
        return type;
    }

    public void getType(int type) {
        this.type = type;
    }

    // listview_item1의 데이터
    private String title;
    private String desc;

    // listview_item2의 데이터
    private Drawable image;
    private String name;

    public ModelItem() {
    }

    // type 0 생성자
    public ModelItem(String title, String desc) {
        this.type = AdapterItem.ITEM_VIEW_TYPE_TEXT;
        this.title = title;
        this.desc = desc;
    }

    // type 1 생성자
    public ModelItem(Drawable image, String name) {
        this.type = AdapterItem.ITEM_VIEW_TYPE_IMAGE;
        this.image = image;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    @Override
    public String toString() {
        return "ModelItem{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", image=" + image +
                ", name='" + name + '\'' +
                '}';
    }
}
