package com.example.android.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailScreenActivity extends AppCompatActivity {

    ImageView img;
    TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        img = findViewById(R.id.desc_img);
        tv1 = findViewById(R.id.desc_header);
        tv2 = findViewById(R.id.desc_desc);

        img.setImageResource(getIntent().getIntExtra("imagename", 0));
        tv1.setText(getIntent().getStringExtra("header"));
        tv2.setText(getIntent().getStringExtra("desc"));

    }
}