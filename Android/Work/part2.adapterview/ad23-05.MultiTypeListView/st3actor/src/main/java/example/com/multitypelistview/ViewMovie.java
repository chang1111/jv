package example.com.multitypelistview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewMovie extends RelativeLayout {

    private ImageView movieImage = null;
    private TextView movieTitle = null;
    private TextView movieYear = null;

    public ViewMovie(Context context) {
        super(context);
        init(context, null, 0);
    }

    public ViewMovie(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public ViewMovie(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        // inflate
        View rowview = LayoutInflater.from(context)
                .inflate(R.layout.view_movie,this,true);

        movieImage = rowview.findViewById(R.id.movieImage);
        movieTitle = rowview.findViewById(R.id.movieTitle);
        movieYear = rowview.findViewById(R.id.movieYear);

    }

    ModelMovie movie;

    public ModelMovie getMovie() {
        return movie;
    }

    public void setMovie(ModelMovie movie) {
        this.movie = movie;

        movieImage.setImageDrawable(movie.getMovieImage());
        movieTitle.setText         (movie.getMovieTitle()   );
        movieYear.setText         (movie.getMovieYear()    );
    }
}
