package tn.enis.enismap;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Acceuil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
         ImageView imageView_img =  (ImageView) findViewById(R.id.imageEnis);
        imageView_img.setOnClickListener (new ImageButton.OnClickListener() {
            public void onClick (View v){
                Intent intent = new Intent (Acceuil.this, MapActivity.class);
                startActivity(intent);
            }
        });


    }
}
