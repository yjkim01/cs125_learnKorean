package com.example.learnkorean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static SaveGame save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = getApplicationContext();

        save = new SaveGame(context);

        TextView level = findViewById(R.id.level);
        level.setText(save.getLevel());

        Button login = findViewById(R.id.practiceBegin);
        login.setOnClickListener(unused -> {
            startActivity(new Intent(this, PracticeActivity.class));
        });
    }
    public static SaveGame getSave() {
        return save;
    }
}
