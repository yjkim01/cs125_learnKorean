package com.example.learnkorean;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveGame {
    private File gameSave;
    public SaveGame(final Context context) {
        gameSave = new File(context.getFilesDir(), "savedata.lk");
        setLevel("Beginner");
    }
    public void setLevel(final String level) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(gameSave);
            fw.write(level);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public String getLevel() {
        try {
            Scanner sc = new Scanner(gameSave);
            return sc.nextLine();
        } catch (FileNotFoundException e) {
            // ok just dont use this before using the constructor
            return "";
        }
    }
}
