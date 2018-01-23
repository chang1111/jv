package example.com.backstack;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn_back;
    private Button btn_next;
    private Button btn_empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_back = findViewById(R.id.btn_back);
        btn_next = findViewById(R.id.btn_next);
        btn_empty = findViewById(R.id.btn_empty);

        ButtonListener buttonListener = new ButtonListener();

        btn_back.setOnClickListener(buttonListener);
        btn_next.setOnClickListener(buttonListener);
        btn_empty.setOnClickListener(buttonListener);

    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            FragmentManager fm = getSupportFragmentManager();
            int count = -1;
            switch (view.getId()) {
                case R.id.btn_back:
                    count = fm.getBackStackEntryCount();
                    if (count > 0) {
                        fm.popBackStack();
                    }
                    break;
                case R.id.btn_next:
                    count = fm.getBackStackEntryCount();
                    if (count < 10) {
                        // MessageFragment 인스턴스 생성
                        // BackStack에 추가

                        // 인스턴스 생성 방법1
                        Bundle b = new Bundle();
                        b.putString(MessageFragment.ARG_PARAM1, String.valueOf(count+1));

                        MessageFragment f = new MessageFragment();
                        f.setArguments(b);

                        //인스턴스 생성 방법2
                        MessageFragment f1 = MessageFragment.newInstance(String.valueOf(count+1));

                        // BackStack에 추가
                        fm.beginTransaction()
                                .replace(R.id.container, f)
                                .addToBackStack("entry" + count)
                                .commit();
                    }
                    break;
                case R.id.btn_empty:
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    break;
            }
        }
    }
}
