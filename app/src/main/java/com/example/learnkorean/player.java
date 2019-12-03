package com.example.learnkorean;

import java.util.ArrayList;

public class player {

    private static int currentStage;
    private static int daysSinceLastPractice;
    private static ArrayList<item> vocabList;

    public player(int stage, int days) {
        currentStage = stage;
        daysSinceLastPractice = days;
        vocabList = new ArrayList<item>();
    }

    public int setCurrentStage(int newStage) {
        currentStage = newStage;
        return currentStage;
    }
    public int getCurrentStage() {
        return currentStage;
    }
    public int setDaysSinceLastPractice(int day) {
        daysSinceLastPractice = day;
        return daysSinceLastPractice;
    }
    public int getDaysSinceLastPractice() {
        return daysSinceLastPractice;
    }
    public void addVocabItem(item i) {
        vocabList.add(i);
    }

}
