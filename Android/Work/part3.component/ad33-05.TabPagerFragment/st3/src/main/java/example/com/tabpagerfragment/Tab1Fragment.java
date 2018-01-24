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

import java.util.ArrayList;
import java.util.List;

public class Tab1Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private List<String> mData;

    private View inflatedView;
    private EditText edtInput;
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private Button btnAdd;

    public Tab1Fragment() {
    }

    public static Tab1Fragment newInstance(String param1, String param2) {
        Tab1Fragment fragment = new Tab1Fragment();
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
        inflatedView = inflater.inflate(R.layout.fragment_tab1, container, false);

        return inflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // ListView 찾기
        // ArrayAdapter 생성
        // ListView와 Adapter 연결
        btnAdd = inflatedView.findViewById(R.id.btn_add);
        listView = inflatedView.findViewById(R.id.list_view);
        mData = makeData();
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mData);
        listView.setAdapter(adapter);

        edtInput = inflatedView.findViewById(R.id.edt_input);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtInput.getText().toString();
                if (!text.isEmpty()) {
                    mData.add(text);
                    adapter.notifyDataSetChanged();
                    listView.smoothScrollToPosition(adapter.getCount()-1 - listView.getHeaderViewsCount() - listView.getFooterViewsCount());
                }
            }
        });

    }

    private List<String> makeData() {
        List<String> list = new ArrayList<String>();
        list.add("item 01");
        list.add("item 02");
        list.add("item 03");
        list.add("item 04");
        list.add("item 05");
        list.add("item 06");
        list.add("item 07");
        list.add("item 08");
        list.add("item 09");
        list.add("item 10");
        list.add("item 11");
        list.add("item 12");
        list.add("item 13");
        list.add("item 13");
        list.add("item 14");
        list.add("item 15");
        list.add("item 16");
        list.add("item 17");
        list.add("item 18");
        list.add("item 19");
        list.add("item 20");
        return list;
    }
}
