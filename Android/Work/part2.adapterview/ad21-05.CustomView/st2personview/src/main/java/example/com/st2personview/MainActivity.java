package example.com.st2personview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private PersonView view_person = null;
    private ImageView imageSelect = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view_person = findViewById(R.id.view_person);
        imageSelect = findViewById(R.id.image_select);

        view_person.setOnImageClickListener(new PersonView.OnImageClickListener() {
            @Override
            public void onImageClick(PersonView view, PersonData person) {
                imageSelect.setImageDrawable(person.getPhoto());
                imageSelect.setVisibility(View.VISIBLE);
            }
        });
    }
}
