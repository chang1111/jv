package example.com.customlistview;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edit_name;
    private EditText edit_number;
    private EditText edit_department;
    private Button btn_add;
    private Spinner spinner;
    private EditText edit_item;
    private Button btn_search;
    private RadioButton radioButton;
    private RadioButton radioButton2;
    private Button btn_sort;
    private Button btn_del;
    private Button btn_all_del;
    private Button btn_init;
    private ListView list_view;
    private StudentAdapter adapter;
    private int spinnerIndex = 1;
    private int index = -1;
    List<Student> list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_name = findViewById(R.id.edit_name);
        edit_number = findViewById(R.id.edit_number);
        edit_department = findViewById(R.id.edit_department);
        btn_add = findViewById(R.id.btn_add);
        spinner = findViewById(R.id.spinner);
        edit_item = findViewById(R.id.edit_itme);
        btn_search = findViewById(R.id.btn_search);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        btn_sort = findViewById(R.id.btn_sort);
        btn_del = findViewById(R.id.btn_del);
        btn_all_del = findViewById(R.id.btn_all_del);
        btn_init = findViewById(R.id.btn_init);

        list = new ArrayList<Student>();

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

        adapter = new StudentAdapter(MainActivity.this, R.layout.listview_item, list);
        initList();

        list_view = findViewById(R.id.list_view);
        list_view.setAdapter(adapter);
        list_view.setDivider(new ColorDrawable(Color.GRAY));
        list_view.setDividerHeight(3);

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
                if (i != 0 && i != list.size() -1) {
                    String name = list.get(i - 1).getName();
                    String number = list.get(i - 1).getNumber();
                    String department = list.get(i - 1).getDepartment();
                    edit_name.setText(name);
                    edit_number.setText(number);
                    edit_department.setText(department);
                    index = i;

//                    String msg = list.get(i-1).toString();
//                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
        list_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i != 0 && i != list.size() - 1) {
                    list.remove(i - list_view.getHeaderViewsCount());
                    adapter.notifyDataSetChanged();
                }
                return false;
            }
        });

        // 리스트에 머리 아이템 추가
        View headerView = getLayoutInflater().inflate( R.layout.list_header_view, null);
        TextView headerTitle = (TextView)headerView.findViewById( R.id.header_footer_text );
        headerTitle.setText( "리스트의 시작입니다." );
        list_view.addHeaderView( headerView, null, true );

        // 리스트에 꼬리 아이템 추가
        View footerView = getLayoutInflater().inflate( R.layout.list_header_view, null );
        TextView footerTitle = (TextView)footerView.findViewById( R.id.header_footer_text );
        footerTitle.setText( "로딩 중..." );
        list_view.addFooterView( footerView, null, false );
    }

    private class Handler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String name = edit_name.getText().toString();
            String number = edit_number.getText().toString();
            String department = edit_department.getText().toString();
            switch (view.getId()) {
                case R.id.btn_add:
                    if (!(name.isEmpty() || number.isEmpty() || department.isEmpty())) {
                        adapter.addItem(name, number, department);
                        edit_name.setText("");
                        edit_number.setText("");
                        edit_department.setText("");
                        adapter.notifyDataSetChanged();
                        index = -1;
                        list_view.smoothScrollToPosition(list.size() - 1);
                    }
                    break;
                case R.id.btn_search:
//                    String keyword = edit_item.getText().toString();
//                    Student student = adapter.search(spinnerIndex, keyword);
//                    if (student != null) {
//                        edit_name.setText(student.getName());
//                        edit_number.setText(student.getNumber());
//                        edit_department.setText(student.getDepartment());
//                        index = list.indexOf(student) + 1;
//                    }
                    String searchItem = getFieldName(spinner.getSelectedItem());
                    String value = edit_item.getText().toString();
                    Student.MyPredicate predicate = new Student.MyPredicate(searchItem, value);
                    List<Student> result = (List<Student>) CollectionUtils.select(list, predicate);
                    adapter.clear();

                    break;

                case R.id.btn_sort:
                    if (radioButton.isChecked()) {
                        adapter.sortList(false, spinnerIndex);
                    } else if (radioButton2.isChecked()) {
                        adapter.sortList(true, spinnerIndex);
                    }
                    edit_name.setText("");
                    edit_number.setText("");
                    edit_department.setText("");
                    adapter.notifyDataSetChanged();
                    index = -1;
                    break;
                case R.id.btn_del:
                    if (index != -1 && index != 0) {
                        edit_name.setText("");
                        edit_number.setText("");
                        edit_department.setText("");
                        adapter.delItem(index-1);
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
                    edit_item.setText("");
                    initList();
                    adapter.notifyDataSetChanged();
                    index = -1;
                    break;
            }
        }

        private String getFieldName(Object selectedItem) {
            if (selectedItem.equals("이름")) {
                return "name";
            }
            else if (selectedItem.equals("학번")) {
                return "number";
            }
            else if (selectedItem.equals("학과")) {
                return "department";
            }
            else {
                return null;
            }
        }
    }

    public void initList() {
        adapter.delAll();
        for (int i = 0; i < 20; i++) {
            String name = "aaa " + i;
            String number;
            if (i < 10) {
                number = "0" + i + "-" + "0" + i;
            }
            else {
                number = "" + i + "-" + i;
            }
            String department = "bbb " + i;
            list.add(new Student(name, number, department));
        }
    }

}
