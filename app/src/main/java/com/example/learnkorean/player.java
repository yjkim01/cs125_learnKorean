package com.example.learnkorean;

import java.util.ArrayList;

public class player {

    private static int currentStage;
    private static ArrayList<vocabitem> vocabList;

    public player(int stage, int days) {
        currentStage = stage;
        vocabList = new ArrayList<vocabitem>();
    }
    public player() {
        currentStage = 0;
        vocabList = new ArrayList<vocabitem>();
    }
    public int setCurrentStage(int newStage) {
        currentStage = newStage;
        return currentStage;
    }
    public int getCurrentStage() {
        return currentStage;
    }
    public void addVocabItem(vocabitem i) {
        vocabList.add(i);
    }
}
