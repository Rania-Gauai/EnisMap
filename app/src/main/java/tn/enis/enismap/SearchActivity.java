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


public class SearchActivity extends AppCompatActivity {
    private FloatingActionButton test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        /*setContentView(R.layout.activity_map);

        String address="file:///android_asset/index.html";
        WebView view=(WebView)this.findViewById(R.id.carte);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(address);
        view.setWebViewClient(new MyBrowser());*/



        final Intent intent = getIntent();


        final String name = intent.getStringExtra("id");


        test = findViewById(R.id.fab_style_one);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // inflate the layout of the popup window
                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.iteneray_popup, null);

                // create the popup window
                int width = LinearLayout.LayoutParams.MATCH_PARENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                // which view you pass in doesn't matter, it is only used for the window tolken
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                Button btnDepart = (Button) popupView.findViewById(R.id.popup_top_button1);


                btnDepart.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent myIntent = new Intent(SearchActivity.this, PlacesActivity.class);
                        myIntent.putExtra("key", "depart"); //Optional parameters
                        SearchActivity.this.startActivity(myIntent);


                    }
                });

                String btnDepartName;
                String btnArriveName;
                Button btnArrive = (Button) popupView.findViewById(R.id.popup_top_button2);
                btnArrive.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent myIntent = new Intent(SearchActivity.this, PlacesActivity.class);
                        myIntent.putExtra("key", "arrive"); //Optional parameters
                        SearchActivity.this.startActivity(myIntent);


                    }
                });
                if (name!= null) {

                    if (intent.getStringExtra("key").equals("depart")) {
                        btnDepartName= name;
                        btnDepart.setText(btnDepartName);

                    }
                    if (intent.getStringExtra("key").equals("arrive")) {
                        btnArriveName= name;
                        btnArrive.setText(btnArriveName);

                    }


                }


                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });


            }
        });
    }

    }

