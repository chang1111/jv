package example.com.tabpagerfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

public class Tab3Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private View inflatedView;
    private EditText edtName;
    private EditText edtNumber;
    private EditText edtDepartment;
    private Button btnAdd;
    private Spinner spinner;
    private EditText edtItem;
    private Button btnSearch;
    private Button btnSort;
    private Button btnDelAll;
    private Button btnInit;
    private ListView listView;
    private StudentAdapter<ModelStudent> adapter;
    private List<ModelStudent> data;

    public Tab3Fragment() {
    }

    public static Tab3Fragment newInstance(String param1, String param2) {
        Tab3Fragment fragment = new Tab3Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab3, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        edtName = inflatedView.findViewById(R.id.edt_name);
//        edtNumber = inflatedView.findViewById(R.id.edt_number);
//        edtDepartment = inflatedView.findViewById(R.id.edt_department);
//        btnAdd = inflatedView.findViewById(R.id.btn_add3);
        spinner = inflatedView.findViewById(R.id.spinner);
//        edtItem = inflatedView.findViewById(R.id.edt_item);
//        btnSearch = inflatedView.findViewById(R.id.btn_search);
//        btnSort = inflatedView.findViewById(R.id.btn_sort);
//        btnDelAll = inflatedView.findViewById(R.id.btn_del_all);
//        btnInit = inflatedView.findViewById(R.id.btn_init);

        String[] items = {"이름", "학번", "학과"};
//        ArrayAdapter<String> sAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, items);
//        spinner.setAdapter(sAdapter);

//        ButtonListener buttonListener = new ButtonListener();
//
//        btnAdd   .setOnClickListener(buttonListener);
//        btnSearch.setOnClickListener(buttonListener);
//        btnSort  .setOnClickListener(buttonListener);
//        btnDelAll.setOnClickListener(buttonListener);
//        btnInit  .setOnClickListener(buttonListener);



    }

//    private class ButtonListener implements View.OnClickListener {
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()) {
//                case R.id.btn_add3:
//                    break;
//                case R.id.btn_search:
//                    break;
//                case R.id.btn_sort:
//                    break;
//                case R.id.btn_del_all:
//                    break;
//                case R.id.btn_init:
//                    break;
//            }
//        }
//    }
}
