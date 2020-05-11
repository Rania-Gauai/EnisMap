package tn.enis.enismap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        String address="file:///android_asset/index.html";
        WebView view=(WebView)this.findViewById(R.id.carte);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(address);
        view.setWebViewClient(new MyBrowser());




    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
}
