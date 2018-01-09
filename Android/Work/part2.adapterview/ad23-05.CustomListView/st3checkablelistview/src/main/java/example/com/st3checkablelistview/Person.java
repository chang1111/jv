package example.com.st3checkablelistview;

import android.graphics.drawable.Drawable;

public class Person {
    private Drawable image;
    private String name;
    private Integer age;
    private boolean checked = false;

    public Person() {

    }

    public Person(Drawable image,String name, Integer age) {
        this.image = image;
        this.name = name;
        this.age = age;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Drawable getImage() {
        return image;
    }

    public void setName(Drawable image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
