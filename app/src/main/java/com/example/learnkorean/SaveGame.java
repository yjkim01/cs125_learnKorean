package com.example.learnkorean;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveGame {
    /** The file where the game's data will be stored. For right now it is just the user's stage. */
    private static File gameSave;

    /**
     * Constructor class for SaveGame. Saves the user's current progress.
     * @param context
     */
    public SaveGame(final Context context) {
        gameSave = new File(context.getFilesDir(), "savedata.lk");
        setLevel("Beginner");
    }

    /**
     * Sets the current level the user is  on, or has advanced to. Saves every time
     * user advances a level.
     * @param level level user is on
     */
    public static void setLevel(final String level) {
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

    /**
     * Gets user's current level.
     * @return user's level
     */
    public static String getLevel() {
        try {
            Scanner sc = new Scanner(gameSave);
            return sc.nextLine();
        } catch (FileNotFoundException e) {
            // ok just dont use this before using the constructor
            return "";
        }
    }
}
