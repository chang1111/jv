package example.com.tabpagerfragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Tab2Fragment extends Fragment {
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
    private Button btnModify;
    private Button btnDel;

    public Tab2Fragment() {
    }

    public static Tab2Fragment newInstance(String param1, String param2) {
        Tab2Fragment fragment = new Tab2Fragment();
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
        inflatedView = inflater.inflate(R.layout.fragment_tab2, container, false);

        return inflatedView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // ListView 찾기
        // ArrayAdapter 생성
        // ListView와 Adapter 연결
        btnAdd = inflatedView.findViewById(R.id.btn_add2);
        btnModify = inflatedView.findViewById(R.id.btn_modify2);
        btnDel = inflatedView.findViewById(R.id.btn_del2);
        listView = inflatedView.findViewById(R.id.list_view2);
        mData = makeData();
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_multiple_choice, mData);
        listView.setAdapter(adapter);

        edtInput = inflatedView.findViewById(R.id.edt_input2);

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
        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtInput.getText().toString();
                SparseBooleanArray a = listView.getCheckedItemPositions();
                for (int i = 0; i < a.size(); i++) {
                    if (a.valueAt(i))
                    mData.set(a.keyAt(i), text);
                }
                listView.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray a = listView.getCheckedItemPositions();
                for (int i = a.size() - 1; i >= 0; i--) {
                    if (a.valueAt(i))
                        mData.remove(a.keyAt(i));
                }
                listView.clearChoices();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private List<String> makeData() {
        List<String> list = new ArrayList<String>();
        list.add("item 01");
        list.add("item 02");
        list.add("item 03");
        list.add("item 04");
        return list;
    }
}
