package example.com.multitypelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    ListView listView;
    private ActorAdapter adapter;
    private ModelActor datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listView = findViewById(R.id.listView);

        // 위젯 설정. 리스너 설정. 생략

        // 데이터 만들기
        datas = makeData();

        // adapter 만들기
        adapter = new ActorAdapter(MainActivity.this, datas);

        // listView와 adapter 연결하기

        listView.setAdapter(adapter);




    }

    private ModelActor makeData() {
        ModelActor actor = new ModelActor();
        actor.setActorImage(getResources().getDrawable(R.drawable.sample_0, null));
        actor.setActorName("ysi");
        actor.setActorAge(42);
        actor.setActorDesc("desc......");

        List<ModelMovie> movies = new ArrayList<ModelMovie>();
        movies.add(new ModelMovie(getResources().getDrawable(R.drawable.sample_1), "movie title 1", "year : 2015"));
        movies.add(new ModelMovie(getResources().getDrawable(R.drawable.sample_2), "movie title 2", "year : 2016"));
        movies.add(new ModelMovie(getResources().getDrawable(R.drawable.sample_3), "movie title 3", "year : 2017"));

        // actor에 movie 추가하기
        actor.setMovies(movies);

        List<ModelDrama> dramas = new ArrayList<ModelDrama>();
        dramas.add(new ModelDrama(getResources().getDrawable(R.drawable.sample_4), "drama title 1", "interval : 1 ~ 3"));
        dramas.add(new ModelDrama(getResources().getDrawable(R.drawable.sample_5), "drama title 2", "interval : 4 ~ 6"));

        // actor에 drama 추가하기
        actor.setDramas(dramas);

        List<ModelComment> comments = new ArrayList<ModelComment>();
        comments.add(new ModelComment("comment 1", "writer 1"));
        comments.add(new ModelComment("comment 2", "writer 2"));

        // actor에 comment 추가하기
        actor.setComments(comments);

        return actor;
    }

}
