package com.example.learnkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();
        Button login = findViewById(R.id.practiceBegin);
        SaveGame save = new SaveGame(context);
        login.setOnClickListener(unused -> {
            startActivity(new Intent(MainActivity.this, PracticeActivity.class));
            finish();
        });
    }
}
