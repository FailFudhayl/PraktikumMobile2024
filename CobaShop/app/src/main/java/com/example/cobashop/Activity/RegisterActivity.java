package com.example.cobashop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cobashop.LocalDatabase.DBHandler;
import com.example.cobashop.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText etUsername, etPassword;
    private Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.ET_UsernameReg);
        etPassword = findViewById(R.id.ET_PasswordReg);
        btnRegister = findViewById(R.id.btn_RegisReg);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    DBHandler dbHandler = new DBHandler(RegisterActivity.this);
                    boolean isInserted = dbHandler.insertUser(username, password);

                    if (isInserted) {
                        Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish(); // Close RegisterActivity
                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration failed, please try again", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}