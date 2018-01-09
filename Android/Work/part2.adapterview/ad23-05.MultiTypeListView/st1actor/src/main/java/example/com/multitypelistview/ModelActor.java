package example.com.multitypelistview;

import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ModelActor {
    private Drawable actorImage;
    private String actorName;
    private Integer actorAge;

    public ModelActor() {
    }

    public ModelActor(Drawable actorImage, String actorName, Integer actorAge) {
        this.actorImage = actorImage;
        this.actorName = actorName;
        this.actorAge = actorAge;
    }

    public Drawable getActorImage() {
        return actorImage;
    }

    public void setActorImage(Drawable actorImage) {
        this.actorImage = actorImage;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public Integer getActorAge() {
        return actorAge;
    }

    public void setActorAge(Integer actorAge) {
        this.actorAge = actorAge;
    }
}
