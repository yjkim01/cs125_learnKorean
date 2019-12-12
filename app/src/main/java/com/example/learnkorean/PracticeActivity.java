package com.example.learnkorean;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class PracticeActivity extends AppCompatActivity {
    /** Question number user is currently on. */
    private int questionNum;
    /** Current set of values of keys depending on the user's level. */
    private Object[] keys;
    /** vocab list */
    private vocabitem vocab;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        //Intent intent = new Intent(this, PracticeActivity.class);
        //startActivity(intent);

        Context context = getApplicationContext();

        vocab = new vocabitem();

        questionNum = 0;

        loadKeys();

        TextView korean = findViewById(R.id.korean);
        TextView answer = findViewById(R.id.answer);
        TextView instructions = findViewById(R.id.instruction);
        Button check = findViewById(R.id.check);
        TextView status = findViewById(R.id.status);
        Button next = findViewById(R.id.next);
        ProgressBar progress = findViewById(R.id.progress);

        next.setVisibility(View.GONE);
        //next.setVisibility(View.VISIBLE);
        korean.setText(keys[questionNum].toString());
        answer.setText("");
        status.setText("Click button to check answer.");
        progress.setProgress(questionNum + 1);
        progress.setMax(keys.length + 1);
        instructions.setText(getInstructions());

        check.setOnClickListener(unused -> {
            boolean isCorrect = checkAnswer(keys[questionNum].toString(), answer.getText().toString());
            if (isCorrect) {
                next.setVisibility(View.VISIBLE);
                status.setText("Correct!");
            } else {
                status.setText("Incorrect!");
            }
        });

        next.setOnClickListener(unused -> {
            next.setVisibility(View.GONE);
            //next.setVisibility(View.VISIBLE);
            if (questionNum == keys.length - 1) {
                nextStage();
                progress.setProgress(0);
                progress.setMax(keys.length);
                instructions.setText(getInstructions());
            } else {
                questionNum++;
                progress.setProgress(questionNum);
            }
            korean.setText(keys[questionNum].toString());
            answer.setText("");
            status.setText("Click button to check answer.");
        });
        //finish();
    }

    /**
     * Progresses the user onto the next stage.
     */
    private void nextStage() {
        if (MainActivity.getSave().getLevel().toLowerCase().equals("beginner")) {
            MainActivity.getSave().setLevel("Intermediate");
        } else if(MainActivity.getSave().getLevel().toLowerCase().equals("intermediate")) {
            MainActivity.getSave().setLevel("Advanced");
        } else if (MainActivity.getSave().getLevel().toLowerCase().equals("advanced")) {
            MainActivity.getSave().setLevel("Beginner");
        }
        System.out.println(MainActivity.getSave().getLevel());
        questionNum = 0;
        loadKeys();
    }

    /**
     * Loads the keys.
     */
    private void loadKeys() {
        if (MainActivity.getSave().getLevel().toLowerCase().equals("intermediate")) {
            System.out.println("1");
            keys = new Object[vocab.wordlets.size() - 1];
            keys = vocab.wordlets.keySet().toArray();
        } else if (MainActivity.getSave().getLevel().toLowerCase().equals("advanced")) {
            System.out.println("2");
            keys = new Object[vocab.words.size() - 1];
            keys = vocab.words.keySet().toArray();
        } else if (MainActivity.getSave().getLevel().toLowerCase().equals("beginner") ){
            System.out.println("3");
            keys = new Object[vocab.characters.size() - 1];
            keys = vocab.characters.keySet().toArray();
        }
    }

    /**
     * Checks if the answer is right (true) or wrong (false).
     * @param q question being asked (key)
     * @param a answer given by user
     * @return if the answer is right (true) or wrong (false)
     */
    private boolean checkAnswer(String q, String a) {
        /**/
        if (MainActivity.getSave().getLevel().toLowerCase().equals("beginner")) {
            return (vocabitem.characters.get(q).equals(a));
        } else if (MainActivity.getSave().getLevel().toLowerCase().equals("intermediate")) {
            return (vocabitem.wordlets.get(q).equals(a));
        } else if (MainActivity.getSave().getLevel().toLowerCase().equals("advanced")) {
            return (vocabitem.words.get(q).equals(a));
        }
        return false;
        /* */
        //return true;
    }

    private String getInstructions() {
        if (MainActivity.getSave().getLevel().toLowerCase().equals("beginner")) {
            return "Enter the pronunciation for the Korean character above.";
        } else if(MainActivity.getSave().getLevel().toLowerCase().equals("intermediate")) {
            return "Enter the pronunciation for the Korean wordlet above.";
        } else if (MainActivity.getSave().getLevel().toLowerCase().equals("advanced")) {
            return "Enter the English word for the Korean word above.";
        }
        return "";
    }
}
