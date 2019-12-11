package com.example.learnkorean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class PracticeActivity extends AppCompatActivity {
    /** User's current level. */
    private String userlevel;
    /** Question number user is currently on. */
    private int questionNum;
    /** Current set of values of keys depending on the user's level. */
    private String[] keys;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        Intent intent = new Intent(this, PracticeActivity.class);

        userlevel = SaveGame.getLevel();
        questionNum = 0;

        loadKeys();

        TextView korean = findViewById(R.id.korean);
        TextView answer = findViewById(R.id.answer);
        Button check = findViewById(R.id.check);
        TextView status = findViewById(R.id.status);
        Button next = findViewById(R.id.next);

        next.setVisibility(View.GONE);
        korean.setText(keys[questionNum]);
        answer.setText("Your Answer");
        status.setText("Click button to check answer.");

        check.setOnClickListener(unused -> {
            boolean isCorrect = checkAnswer(keys[questionNum], answer.getText().toString());
            if (isCorrect) {
                next.setVisibility(View.VISIBLE);
                status.setText("Correct!");
            } else {
                status.setText("Incorrect!");
            }
        });

        next.setOnClickListener(unused -> {
            next.setVisibility(View.GONE);
            if (questionNum == keys.length) {
                nextStage();
            } else {
                questionNum++;
            }
            korean.setText(keys[questionNum]);
            answer.setText("Your Answer");
            status.setText("Click button to check answer.");
        });
    }

    /**
     * Progresses the user onto the next stage.
     */
    private void nextStage() {
        if (userlevel.toLowerCase().equals("beginner")) {
            SaveGame.setLevel("Intermediate");
        } else if(userlevel.toLowerCase().equals("intermediate")) {
            SaveGame.setLevel("Advanced");
        } else if (userlevel.toLowerCase().equals("advanced")) {
            SaveGame.setLevel("Complete");
        }
        questionNum = 0;
        loadKeys();
    }

    /**
     * Loads the keys.
     */
    private void loadKeys() {
        if (userlevel.toLowerCase().equals("beginner")) {
            keys = (String[]) vocabitem.characters.keySet().toArray();
        } else if(userlevel.toLowerCase().equals("intermediate")) {
            keys = (String[]) vocabitem.wordlets.keySet().toArray();
        } else if (userlevel.toLowerCase().equals("advanced")) {
            keys = (String[]) vocabitem.words.keySet().toArray();
        }
    }

    /**
     * Checks if the answer is right (true) or wrong (false).
     * @param q question being asked (key)
     * @param a answer given by user
     * @return if the answer is right (true) or wrong (false)
     */
    private boolean checkAnswer(String q, String a) {
        if (userlevel.toLowerCase() == "beginner") {
            return (vocabitem.characters.get(q).equals(a));
        } else if (userlevel.toLowerCase() == "intermediate") {
            return (vocabitem.wordlets.get(q).equals(a));
        } else if (userlevel.toLowerCase().equals("advanced")) {
            return (vocabitem.words.get(q).equals(a));
        }
        return false;
    }
}
