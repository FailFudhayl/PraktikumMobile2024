package com.example.cobashop.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.cobashop.R;
import com.example.cobashop.SharedPrefrence.SharedPrefManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    // Delay selama 3 detik
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Setelah delay, pindah ke Activity yang sesuai
                if (SharedPrefManager.getInstance(SplashActivity.this).isLoggedIn()) {
                    // Jika sudah login, langsung ke HalamanActivity
                    startActivity(new Intent(SplashActivity.this, HalamanActivity.class));
                } else {
                    // Jika belum login, ke MainActivity
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                finish();
            }
        });
    }
}