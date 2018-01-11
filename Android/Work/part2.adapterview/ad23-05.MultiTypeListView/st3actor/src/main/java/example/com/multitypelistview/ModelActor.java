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

    public void setMovies(List<ModelMovie> movies) {
        this.movies = movies;
    }

    public List<ModelDrama> getDramas() {
        return dramas;
    }

    public void setDramas(List<ModelDrama> dramas) {
        this.dramas = dramas;
    }

    public List<ModelComment> getComments() {
        return comments;
    }

    public void setComments(List<ModelComment> comments) {
        this.comments = comments;
    }

    public ModelActor() {
    }

    public ModelActor(Drawable actorImage, String actorName, Integer actorAge, String actorDesc) {
        this.actorImage = actorImage;
        this.actorName = actorName;
        this.actorAge = actorAge;
        this.actorDesc = actorDesc;
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
        this.actorDesc = actorDesc;
    }

}
