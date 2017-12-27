package example.com.adapterview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private TextView textview1;
    private Spinner spinner1;
    private AutoCompleteTextView autocomplete1;
    private ListView listview1;
    private String[] items = {"1", "2", "3", "4", "5"};
    private String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};
    private String[] itemsLV = {"a", "b", "c", "d", "e"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        textview1 = findViewById(R.id.textview1);
        spinner1 = findViewById(R.id.spinner1);
        autocomplete1 = findViewById(R.id.autocomplete1);
        listview1 = findViewById(R.id.listview1);

        // adapter 생성

        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, items);

        //spinner와 adapter 연결
        spinner1.setAdapter(adapterSpinner);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selecteditem = items[i];

                textview1.setText(selecteditem);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*
            AutoCompleteTextView와 adapter 연동
            1. 데이터 만들기
            2. adapter 생성
            3. AutoCompleteTextView와 adapter 연결
            4. 리스너 생성 AutoCompleteTextView에는 필요없음
         */
        ArrayAdapter<String> adapterMonth = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, months);

        autocomplete1.setAdapter(adapterMonth);

        autocomplete1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selecteditem = ((TextView)view).getText().toString();

                textview1.setText(selecteditem);
            }
        });

        /*
            ListView와 adapter 연동
            1. 데이터 만들기
            2. adapter 생성
            3. ListView와 adapter 연결
            4. 리스너 생성
         */
        ArrayAdapter<String> adapterLV = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, itemsLV);

        listview1.setAdapter(adapterLV);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selecteditem = ((TextView)view).getText().toString();

                textview1.setText(selecteditem);
            }
        });
    }
}
