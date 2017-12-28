package example.com.st4checklistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
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

        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });

        Handler handler = new Handler();

        btnAdd.setOnClickListener(handler);
        btnModify.setOnClickListener(handler);
        btnDelete.setOnClickListener(handler);

    }

    private class Handler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String text = editText.getText().toString();
            SparseBooleanArray positions = listView.getCheckedItemPositions();
            switch (view.getId()) {
                case R.id.btnAdd:
                    if (!text.isEmpty()) {
                        adapter.add(text);
                        listView.smoothScrollToPosition(list.size()-1);
                        editText.setText("");
                    }
                    break;
                case R.id.btnModify:
                    if (!text.isEmpty()) {
                        for (int i = 0; i < positions.size(); i++) {
                            if (positions.valueAt(i)) {
                                list.set(positions.keyAt(i), text);
                                editText.setText("");
                            }
                        }
                        adapter.notifyDataSetChanged();
                    }
                    break;
                case R.id.btnDelete:
                    if (positions.size() != 0) {
                        for (int i = positions.size()-1; i >= 0; i--) {
                            if (positions.valueAt(i)) {
                                list.remove(positions.keyAt(i));

                            }
                        }
                        listView.clearChoices();
                        adapter.notifyDataSetChanged();
                    }

            }
        }
    }
}
