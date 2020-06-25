package tn.enis.enismap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import android.view.Gravity;

import android.view.MotionEvent;

import android.widget.Button;

import android.widget.PopupWindow;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MapActivity extends AppCompatActivity {
    private FloatingActionButton test;
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
    private class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
}
