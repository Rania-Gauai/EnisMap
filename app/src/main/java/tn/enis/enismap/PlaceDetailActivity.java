package tn.enis.enismap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class PlaceDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_place_detail);
        setContentView(R.layout.activity_place_detail);
        Intent intent = getIntent();
        final String name = intent.getStringExtra("key"); }
}
