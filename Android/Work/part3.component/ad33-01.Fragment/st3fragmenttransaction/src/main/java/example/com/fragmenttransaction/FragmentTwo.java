package example.com.fragmenttransaction;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class FragmentTwo extends Fragment {

    public static final String KEY_INPUT = "input";
    private static final int REQUEST_CODE_OTHER_ACTIVITY = 10000;
    private String inputText;
    private EditText inputView;
    private TextView messageView;
    private Button btnSend;
    private Button btnSend2;
    private Button btnActivity;

    public static FragmentTwo newInstance(String input) {
        FragmentTwo fragment = new FragmentTwo();
        Bundle b = new Bundle();
        b.putString(KEY_INPUT, "");
        fragment.setArguments(b);
        return fragment;
    }

    OnMessageCallback callback;
    public interface OnMessageCallback {
        void displayMessage(String message);
    }

    public FragmentTwo() {
    }

    // Life-Cycle method

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Callback Listener 작성
        if (context instanceof OnMessageCallback) {
            callback = (OnMessageCallback) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activity에서 넘긴 Bundle 받기
        Bundle b = getArguments();
        if (b != null) {
            inputText = b.getString(KEY_INPUT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // inflation
        View view = inflater.inflate(R.layout.fragment_two, container, false);

        inputView = view.findViewById(R.id.edit_input);
        messageView = view.findViewById(R.id.text_message);
        btnSend = view.findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = inputView.getText().toString();
                messageView.setText(msg);

                // MainActivity의 메서드 호출을 이용한 값 전달
                ((MainActivity) getActivity()).update(msg);
            }
        });
        btnSend2 = view.findViewById(R.id.btn_send2);
        btnSend2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String msg = inputView.getText().toString();
                messageView.setText(msg);
                // callback 리스너를 이용한 값 전달
                if (callback != null) {
                    callback.displayMessage(msg);
                }
            }
        });
        btnActivity = view.findViewById(R.id.btn_activity);
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), OtherActivity.class);
                startActivityForResult(intent, REQUEST_CODE_OTHER_ACTIVITY);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_OTHER_ACTIVITY && resultCode == android.app.Activity.RESULT_OK) {
            String result = data.getStringExtra(Common.OTHER_RESULT);
            messageView.setText(result);
        }
    }
}
