package com.example.cobashop.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.cobashop.Fragment.BerandaFragment;
import com.example.cobashop.R;

public class HalamanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman);

        BerandaFragment berandaFragment = new BerandaFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(BerandaFragment.class.getSimpleName());

        if (!(fragment instanceof BerandaFragment)){
            fragmentManager
                    .beginTransaction()
                    .add(R.id.frame_container, berandaFragment)
                    .commit();
        }
    }
}