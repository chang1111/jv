package example.com.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private EditText edit_name;
    private EditText edit_number;
    private EditText edit_department;
    private Button btn_add;
    private Spinner spinner;
    private EditText edit_itme;
    private Button btn_search;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private Button btn_sort;
    private Button btn_del;
    private Button btn_all_del;
    private Button btn_init;
    private ListView list_view;
    private ListViewAdapter adapter;
    private int spinnerIndex = 1;
    private int index = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name = findViewById(R.id.edit_name);
        edit_number = findViewById(R.id.edit_number);
        edit_department = findViewById(R.id.edit_department);
        btn_add = findViewById(R.id.btn_add);
        spinner = findViewById(R.id.spinner);
        edit_itme = findViewById(R.id.edit_itme);
        btn_search = findViewById(R.id.btn_search);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        btn_sort = findViewById(R.id.btn_sort);
        btn_del = findViewById(R.id.btn_del);
        btn_all_del = findViewById(R.id.btn_all_del);
        btn_init = findViewById(R.id.btn_init);

        String[] array = {"이름", "번호", "학과"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, array);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerIndex = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        adapter = new ListViewAdapter();
        adapter.initList();

        list_view = findViewById(R.id.list_view);
        list_view.setAdapter(adapter);

        Handler handler = new Handler();
        btn_add.setOnClickListener(handler);
        btn_search.setOnClickListener(handler);
        btn_sort.setOnClickListener(handler);
        btn_del.setOnClickListener(handler);
        btn_all_del.setOnClickListener(handler);
        btn_init.setOnClickListener(handler);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapter.getList().get(i).getName();
                String number = adapter.getList().get(i).getNumber();
                String department = adapter.getList().get(i).getDepartment();
                edit_name.setText(name);
                edit_number.setText(number);
                edit_department.setText(department);
                index = i;
            }
        });

    }

    private class Handler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String name = edit_name.getText().toString();
            String number = edit_number.getText().toString();
            String department = edit_department.getText().toString();
            switch(view.getId()) {
                case R.id.btn_add:
                    if (!(name.isEmpty()||number.isEmpty()||department.isEmpty())) {
                        adapter.addItem(name, number, department);
                        edit_name.setText("");
                        edit_number.setText("");
                        edit_department.setText("");
                        adapter.notifyDataSetChanged();
                        index = -1;
                    }
                    break;
                case R.id.btn_search:
                    String keyword = edit_itme.getText().toString();
                    Student student = adapter.search(spinnerIndex, keyword);
                    if (student != null) {
                        edit_name.setText(student.getName());
                        edit_number.setText(student.getNumber());
                        edit_department.setText(student.getDepartment());
                        index = adapter.getList().indexOf(student);
                    }
                    break;
                case R.id.btn_sort:
                    if (radioButton.isChecked()) {
                        adapter.sortList();
                    }
                    else if (radioButton2.isChecked()) {
                        adapter.reverseList();
                    }
                    edit_name.setText("");
                    edit_number.setText("");
                    edit_department.setText("");
                    adapter.notifyDataSetChanged();
                    index = -1;
                    break;
                case R.id.btn_del:
                    if (index != -1) {
                        edit_name.setText("");
                        edit_number.setText("");
                        edit_department.setText("");
                        adapter.delItem(index);
                        adapter.notifyDataSetChanged();
                        index = -1;
                    }
                    break;
                case R.id.btn_all_del:
                    edit_name.setText("");
                    edit_number.setText("");
                    edit_department.setText("");
                    adapter.delAll();
                    adapter.notifyDataSetChanged();
                    index = -1;
                    break;
                case R.id.btn_init:
                    edit_name.setText("");
                    edit_number.setText("");
                    edit_department.setText("");
                    adapter.initList();
                    adapter.notifyDataSetChanged();
                    index = -1;
                    break;
            }
        }
    }
}
