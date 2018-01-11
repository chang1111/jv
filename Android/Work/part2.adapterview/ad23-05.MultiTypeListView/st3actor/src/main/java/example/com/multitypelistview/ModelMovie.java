package example.com.multitypelistview;

import android.graphics.drawable.Drawable;

public class ModelMovie {

    private Drawable movieImage = null;
    private String movieTitle = ""  ;
    private String movieYear = ""  ;

    public Drawable getMovieImage() {
        return movieImage;
    }

    public void setMovieImage(Drawable movieImage) {
        this.movieImage = movieImage;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    @Override
    public String toString() {
        return "ModelMovie{" +
                "movieImage=" + movieImage +
                ", movieTitle='" + movieTitle + '\'' +
                ", movieYear='" + movieYear + '\'' +
                '}';
    }

    public ModelMovie(Drawable movieImage, String movieTitle, String movieYear) {
        this.movieImage = movieImage;
        this.movieTitle = movieTitle;
        this.movieYear = movieYear;
    }

    public ModelMovie() {
    }
}
