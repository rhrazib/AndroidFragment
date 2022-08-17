package com.razib.androidfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.razib.androidfragment.fragment.FirstFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerView,new FirstFragment()).commit();


    }
}