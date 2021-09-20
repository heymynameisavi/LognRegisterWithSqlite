package com.example.android.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView email_text;
    Button logout_button, getApiData_button, getNotesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        email_text = findViewById(R.id.email_text);
        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        email_text.setText(emailFromIntent);

        logout_button = findViewById(R.id.logout);
        getApiData_button = findViewById(R.id.getApiData);
        getNotesButton = findViewById(R.id.getToNote);

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logoutIntent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(logoutIntent);
                finish();
                Toast.makeText(HomeActivity.this, "Successfully logout", Toast.LENGTH_SHORT).show();
            }
        });

        getApiData_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ThirdPartyApiData.class);
                startActivity(intent);
            }
        });

        getNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainNotesActivity.class);
                startActivity(intent);
            }
        });

    }
}