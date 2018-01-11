package example.com.multitypelistview;

import android.graphics.drawable.Drawable;

public class ModelDrama {

    private Drawable dramaImage = null;
    private String dramaTitle = ""  ;
    private String dramaInterval = ""  ;

    public Drawable getDramaImage() {
        return dramaImage;
    }

    public void setDramaImage(Drawable dramaImage) {
        this.dramaImage = dramaImage;
    }

    public String getDramaTitle() {
        return dramaTitle;
    }

    public void setDramaTitle(String dramaTitle) {
        this.dramaTitle = dramaTitle;
    }

    public String getDramaInterval() {
        return dramaInterval;
    }

    public void setDramaInterval(String dramaInterval) {
        this.dramaInterval = dramaInterval;
    }

    @Override
    public String toString() {
        return "ModelDrama{" +
                "dramaImage=" + dramaImage +
                ", dramaTitle='" + dramaTitle + '\'' +
                ", dramaInterval='" + dramaInterval + '\'' +
                '}';
    }
    public ModelDrama() {
    }

    public ModelDrama(Drawable dramaImage, String dramaTitle, String dramaInterval) {
        this.dramaImage = dramaImage;
        this.dramaTitle = dramaTitle;
        this.dramaInterval = dramaInterval;
    }
}
