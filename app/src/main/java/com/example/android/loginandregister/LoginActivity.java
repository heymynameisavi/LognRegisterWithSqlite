package com.example.android.loginandregister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.loginandregister.helper.DatabaseHelper;

public class LoginActivity extends AppCompatActivity {

    EditText email, password;
    Button btnLogin;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);

        btnLogin = findViewById(R.id.btnLogin);
        databaseHelper = new DatabaseHelper(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString().trim();
                String user_password = password.getText().toString().trim();

                if (user_email.equals("")||user_password.equals(""))
                {
                    Toast.makeText(LoginActivity.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Boolean checkuserpass = databaseHelper.checkusernamepassword(user_email, user_password); {
                        if (checkuserpass==true){
                            Toast.makeText(LoginActivity.this, "Signin Successful", Toast.LENGTH_SHORT).show();
                            //Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            //startActivity(intent);

                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            intent.putExtra("EMAIL", email.getText().toString().trim());
                            //emptyInputEditText();
                            startActivity(intent);

                        } else {
                            Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}