package example.com.st3checkablelistview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private PersonAdapter adapter;
    private List<Person> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Person>();
        list = initData();

        adapter = new PersonAdapter(MainActivity.this, R.layout.view_person, list);

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setDivider(new ColorDrawable(Color.GRAY));
        listView.setDividerHeight(3);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                if (list.get(position).isChecked()) {
//                    list.get(position).setChecked(false);
//                }
//                else {
//                    list.get(position).setChecked(true);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//        });

    }

    private List<Person> initData() {
        List<Person> list = new ArrayList<Person>();

        Random r = new Random();
        for(int i=0; i<40; i++){
            Person person = new Person();
            person.setName( "name " + i );
            person.setAge( 20 + r.nextInt( 30) );
            person.setImage( getResources().getDrawable( imageIds[ i % imageIds.length ] , null) );

            list.add( person );
        }

        return list;
    }

    private int [] imageIds = {
            R.drawable.sample_0
            , R.drawable.sample_1
            , R.drawable.sample_2
            , R.drawable.sample_3
            , R.drawable.sample_4
            , R.drawable.sample_5
            , R.drawable.sample_6
            , R.drawable.sample_7
    };
}


