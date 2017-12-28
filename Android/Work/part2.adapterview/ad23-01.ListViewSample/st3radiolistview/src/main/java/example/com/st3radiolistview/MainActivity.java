package example.com.st3radiolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private EditText editText;
    private Button btnAdd;
    private Button btnModify;
    private Button btnDelete;

    ArrayAdapter<String> adapter;
    List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.btnAdd);
        btnModify = findViewById(R.id.btnModify);
        btnDelete = findViewById(R.id.btnDelete);

        String[] array = getResources().getStringArray(R.array.items);

        list = new ArrayList<String>(Arrays.asList(array));

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice, list);
        listView.setAdapter(adapter);

        Handler handler = new Handler();

        btnAdd.setOnClickListener(handler);
        btnModify.setOnClickListener(handler);
        btnDelete.setOnClickListener(handler);

    }

    private class Handler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String text = editText.getText().toString();
            int position = listView.getCheckedItemPosition();
            switch (view.getId()) {
                case R.id.btnAdd:
                    if (!text.isEmpty()) {
                        adapter.add(text);
                        listView.smoothScrollToPosition(list.size()-1);
                        editText.setText("");
                    }
                    break;
                case R.id.btnModify:
                    if (!text.isEmpty() && position != -1) {
                        list.set(position, text);
                        adapter.notifyDataSetChanged();
                        editText.setText("");
                    }
                    break;
                case R.id.btnDelete:
                    if (position != -1) {
                        list.remove(position);
                        listView.setItemChecked(position,false);
                        adapter.notifyDataSetChanged();
                    }
                    break;
            }
        }
    }
}
