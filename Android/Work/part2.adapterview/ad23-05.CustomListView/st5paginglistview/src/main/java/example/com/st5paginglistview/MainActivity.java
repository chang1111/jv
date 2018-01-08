package example.com.st5paginglistview;

import android.app.ProgressDialog;
import android.graphics.ColorSpace;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private ListView listView;
    private List<ModelItem> data;

    // 아답터 선언
    private ItemAdapter adapter;
    private boolean modeGetData = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        data = new ArrayList<ModelItem>();
        makeData(0, 20);

        adapter = new ItemAdapter(MainActivity.this, R.layout.view_item, data);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // AlertDialog 로 출력하기
                ModelItem item = data.get( position );

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle( item.getName() );
                builder.setMessage( item.toString() );
                builder.setIcon( R.mipmap.ic_launcher );
                builder.setPositiveButton("확인", null);
                builder.show();

            }
        });

        // adapter scroll listener 설정
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if( totalItemCount == firstVisibleItem + visibleItemCount ){
                    // 바닥이다.
                    // 데이터 추가.
                    if( modeGetData == false ) {
                        modeGetData = true;

                        // 1. 네트워크를 통해 데이터 요청
                        List<ModelItem> items = null;
                        items = makeData(data.size(), 20);

                        // 2. 통신 완료 후 받은 데이터 작업
                        data.addAll( items );
                        adapter.notifyDataSetChanged();
                        modeGetData = false;

                        new HttpGetData().execute(data.size(), 20);
                    }
                }
            }

        });
    }
    private int [] imageIds = {
            R.drawable.icon01
            , R.drawable.icon02
            , R.drawable.icon03
            , R.drawable.icon04
            , R.drawable.icon05
            , R.drawable.icon06
    };

    // 임의의 문자열 만들기
    private String getRandString() {
        String str = "";
        for (int i = 1; i <= (int) (Math.random()*10000); i++) {
            char ch = (char) ((Math.random() * 11172) + 0xAC00);
            str += String.valueOf( (char) ((Math.random() * 26) + 97) );
        }
        return str;
    }

    private List<ModelItem> makeData(int start, int count) {
        Random r = new Random();

        List<ModelItem> list = new ArrayList<ModelItem>();

        for(int i=start; i<start + count; i++){
            ModelItem item = new ModelItem();
            item.setImage( getResources().getDrawable( imageIds[ i % imageIds.length ] , null) );
            item.setName( "name " + i );
            item.setPrice( 20 + r.nextInt( 3000) + "");
            item.setDescription( getRandString() );

            list.add( item );
        }

        return list;
    }

    private class HttpGetData extends AsyncTask<Integer, Integer, List<ModelItem>> {

        private ProgressDialog pdlg = null;

        // 요청 전. 네트워크로 데이터 요청하기 직전에 실행되는 메서드
        // 사용자에게 요청을 알림 표시. ProgressDialog 표시
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pdlg = new ProgressDialog(MainActivity.this);
            pdlg.setMessage("기다려...");
            pdlg.show();
        }

        // 요청 중
        @Override
        protected List<ModelItem> doInBackground(Integer... integers) {
            List<ModelItem> temp = null;

            try {
                // 2초간 기다리기... sleep 주기
                Thread.sleep(4000);

                // 1. 네트워크를 통해 데이터 요청
                temp = makeData(integers[0], integers[1]);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            return temp;
        }

        // 요청 후. 네트워크로 데이터 요청이 완료되었을 때 실행되는 메서드
        // 사용자에게 요청을 알림 제거. 시계 제거
        @Override
        protected void onPostExecute(List<ModelItem> modelItems) {
            super.onPostExecute(modelItems);

            if (pdlg != null) {
                pdlg.dismiss();
                pdlg = null;
            }

            // 2. 통신 완료 후 받은 데이터 작업
            // 데이터 받은 후의 작업
            data.addAll(modelItems);
            adapter.notifyDataSetChanged();
//            modegetData = false;
        }

    }
}
