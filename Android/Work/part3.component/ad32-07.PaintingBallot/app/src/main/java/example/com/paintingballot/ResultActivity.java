package example.com.paintingballot;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.content.Intent;

public class ResultActivity extends AppCompatActivity {

    private TextView title;
    private ImageView image;
    private RatingBar rating1;
    private RatingBar rating2;
    private RatingBar rating3;
    private RatingBar rating4;
    private RatingBar rating5;
    private RatingBar rating6;
    private RatingBar rating7;
    private RatingBar rating8;
    private RatingBar rating9;
    private Button finish;
    private Intent intent;

    private String[] titleText = {
            "Title 01",
            "Title 02",
            "Title 03",
            "Title 04",
            "Title 05",
            "Title 06",
            "Title 07",
            "Title 08",
            "Title 09"
    };
    private int[] imageId = {
            R.drawable.mov00,
            R.drawable.mov01,
            R.drawable.mov02,
            R.drawable.mov03,
            R.drawable.mov04,
            R.drawable.mov05,
            R.drawable.mov06,
            R.drawable.mov07,
            R.drawable.mov08
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        intent = getIntent();
        final int[] rating = intent.getIntArrayExtra("rating");
        int max_title = 0;
        int max_rating = 0;
        for (int i = 0; i < rating.length; i++) {
            if (rating[i] > max_rating) {
                max_title = i;
                max_rating = rating[i];
            }
        }

        title = findViewById(R.id.title);
        title.setText(titleText[max_title]);
        image = findViewById(R.id.image);
        image.setImageResource(imageId[max_title]);
        rating1 = findViewById(R.id.rating1);
        rating2 = findViewById(R.id.rating2);
        rating3 = findViewById(R.id.rating3);
        rating4 = findViewById(R.id.rating4);
        rating5 = findViewById(R.id.rating5);
        rating6 = findViewById(R.id.rating6);
        rating7 = findViewById(R.id.rating7);
        rating8 = findViewById(R.id.rating8);
        rating9 = findViewById(R.id.rating9);

        rating1.setRating(rating[0]);
        rating2.setRating(rating[1]);
        rating3.setRating(rating[2]);
        rating4.setRating(rating[3]);
        rating5.setRating(rating[4]);
        rating6.setRating(rating[5]);
        rating7.setRating(rating[6]);
        rating8.setRating(rating[7]);
        rating9.setRating(rating[8]);

        finish = findViewById(R.id.finish);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.putExtra("title", title.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
