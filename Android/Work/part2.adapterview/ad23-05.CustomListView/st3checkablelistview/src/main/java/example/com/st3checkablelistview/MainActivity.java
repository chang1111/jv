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

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private PersonAdapter adapter;
    private List<Person> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<Person>();

        adapter = new PersonAdapter(MainActivity.this, R.layout.view_person, list);
        init();

        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setDivider(new ColorDrawable(Color.GRAY));
        listView.setDividerHeight(3);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (list.get(position).isChecked()) {
                    list.get(position).setChecked(false);
                }
                else {
                    list.get(position).setChecked(true);
                }
                adapter.notifyDataSetChanged();
            }

        });

    }

    public void init() {
        list.add(new Person(getResources().getDrawable(R.drawable.sample_0), "name 0", "22"));
        list.add(new Person(getResources().getDrawable(R.drawable.sample_1), "name 1", "22"));
        list.add(new Person(getResources().getDrawable(R.drawable.sample_2), "name 2", "22"));
        list.add(new Person(getResources().getDrawable(R.drawable.sample_3), "name 3", "22"));
        list.add(new Person(getResources().getDrawable(R.drawable.sample_4), "name 4", "22"));
        list.add(new Person(getResources().getDrawable(R.drawable.sample_5), "name 5", "22"));
        list.add(new Person(getResources().getDrawable(R.drawable.sample_6), "name 6", "22"));
        list.add(new Person(getResources().getDrawable(R.drawable.sample_7), "name 7", "22"));
    }

}
