package example.com.multitypelistview;

import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-01-09.
 */

public class ModelActor {
    private Drawable actorImage;
    private String actorName;
    private Integer actorAge;
    private String actorDesc;

    //child 데이터
    List<ModelMovie> movies = new ArrayList<ModelMovie>();
    List<ModelDrama> dramas = new ArrayList<ModelDrama>();
    List<ModelComment> comments = new ArrayList<ModelComment>();

    public List<ModelMovie> getMovies() {
        return movies;
    }

    public List<ModelDrama> getDramas() {
        return dramas;
    }

    public List<ModelComment> getComments() {
        return comments;
    }

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

    public String getActorDesc() {
        return actorDesc;
    }

    public void setActorDesc(String actorDesc) {
        this.actorName = actorDesc;
    }

}
