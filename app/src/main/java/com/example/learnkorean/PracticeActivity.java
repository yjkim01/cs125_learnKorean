package com.example.learnkorean;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class PracticeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        TextView korean = findViewById(R.id.korean);
        TextView answer = findViewById(R.id.answer);
        Button check = findViewById(R.id.check);
        TextView status = findViewById(R.id.status);


    }
    private void loadQuestion(String userlevel) {
        if (userlevel == "beginner") {
            String[] beginnerkeys  = (String[]) vocabitem.characters.keySet().toArray();
        } else if (userlevel == "intermediate") {
            String[] intermediatekeys  = (String[]) vocabitem.wordlets.keySet().toArray();
        } else {
            String[] advancedkeys  = (String[]) vocabitem.words.keySet().toArray();
        }
    }

    private void checkAnswer() {

    }

    private void updateUserStatus() {

    }
}
