package com.example.learnkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.);
        login.setOnClickListener(unused -> {
            startActivity(new Intent(MainActivity.this, PracticeActivity.class));
            finish();
        });
    }
}
