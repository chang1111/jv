package example.com.prj;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;

import com.google.firebase.iid.FirebaseInstanceId;

import java.util.List;

import example.com.prj.http.HttpPost;
import example.com.prj.model.ModelPost;

import static java.sql.DriverManager.println;

public class MainActivity extends AppCompatActivity {

    private Button refreshBtn;
    private ListView listView;
    private PostAdapter mAdapter;
    private List<ModelPost> mData;
    private String regId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshBtn = findViewById(R.id.refresh);
        listView = findViewById(R.id.listView);

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetPostListTask( MainActivity.this).execute(1, 100);
            }
        });

        new GetPostListTask( MainActivity.this).execute(1, 100);


        getRegistrationId();

        Intent intent = getIntent();
        if (intent != null) {
            processIntent(intent);
        }
    }

    public void getRegistrationId() {
        println("getRegistrationId() 호출됨.");

        regId = FirebaseInstanceId.getInstance().getToken();
        println("regId : " + regId);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        println("onNewIntent() called.");

        if (intent != null) {
            processIntent(intent);
        }

        super.onNewIntent(intent);
    }

    private void processIntent(Intent intent) {
        String from = intent.getStringExtra("from");
        if (from == null) {
            println("from is null.");
            return;
        }

        String contents = intent.getStringExtra("contents");

        println("DATA : " + from + ", " + contents);
//        messageOutput.setText("[" + from + "]로부터 수신한 데이터 : " + contents);
    }

    void setActivity() {
        mAdapter = new PostAdapter(MainActivity.this, R.layout.custom_list_view, mData);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                intent.putExtra("postno", mData.get(i).getPostno());
                startActivity(intent);
            }
        });

    }

    public class GetPostListTask extends SiteAsyncTask< Integer, Integer, List<ModelPost> > {

        public GetPostListTask(Context context) {
            super(context);
        }

        @Override
        protected List<ModelPost> doInBackground(Integer... integer) {
            List<ModelPost> result = new HttpPost().getPostList(integer[0], integer[1]);
            return result;
        }

        @Override
        protected void onPostExecute(List<ModelPost> list) {
            super.onPostExecute(list);

            mData = list;

            setActivity();
        }

    }

}
