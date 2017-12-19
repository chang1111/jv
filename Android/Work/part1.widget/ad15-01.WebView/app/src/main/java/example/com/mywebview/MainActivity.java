package example.com.mywebview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText textUrl = null;
    private Button btnGo = null;
    private Button btnPrev = null;
    private WebView webView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textUrl = findViewById(R.id.textUrl);
        btnGo = findViewById(R.id.btnGo);
        btnPrev = findViewById(R.id.btnPrev);
        webView = findViewById(R.id.webView);


        Handler handler = new Handler();
        btnGo.setOnClickListener(handler);
        btnPrev.setOnClickListener(handler);

        // webview
        // WebViewClient 구현 클래스를 이용한 줌인 기능 추가
        // WebView.loadUrl() : 사이트 열기
        // WebView.goBack()  : 뒤로 가기

        webView.setWebViewClient(new MyWebClient());
        WebSettings settings = webView.getSettings();
        settings.setBuiltInZoomControls(true);
    }

    private class Handler implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btnGo:
                    String url = textUrl.getText().toString();
                    webView.loadUrl(url);
                    break;
                case R.id.btnPrev:
                    webView.goBack();
                    break;
            }
        }
    }

    // webview
    // WebViewClient 구현 클래스
    // WebView.loadUrl() : 사이트 열기
    // WebView.goBack()  : 뒤로 가기

    private class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

}
