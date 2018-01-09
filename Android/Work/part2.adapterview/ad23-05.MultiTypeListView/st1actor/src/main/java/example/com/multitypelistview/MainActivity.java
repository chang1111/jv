package example.com.multitypelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView actorView;
    private ActorAdapter actorAdapter;
    private List<ModelActor> actor;

    private ListView movieList;
    private ListView dramaList;
    private ListView commentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actorView = findViewById(R.id.actorView);

        actor = initActor();
        actorAdapter = new ActorAdapter(MainActivity.this, R.layout.view_actor, actor);
        actorView.setAdapter(actorAdapter);




    }

    private List<ModelActor> initActor() {
        List<ModelActor> list = new ArrayList<ModelActor>();
        list.add(new ModelActor(getResources().getDrawable(R.drawable.sample_0), "aaa", 123));

        return list;
    }
}
