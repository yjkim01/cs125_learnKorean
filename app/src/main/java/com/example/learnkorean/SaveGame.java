package com.example.learnkorean;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SaveGame {
    /** The file where the game's data will be stored. For right now it is just the user's stage. */
    private static File gameSave;
    private static String contents;
    private static Context context;

    /**
     * Constructor class for SaveGame. Saves the user's current progress.
     * @param context
     */
    public SaveGame(final Context context) {
        this.context = context;
        //following tutorial from developer.android.com
        try {
            FileInputStream fis = context.openFileInput("savedata.lk");
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                String line = reader.readLine();
                while (line != null) {
                    stringBuilder.append(line).append('\n');
                    line = reader.readLine();
                }
            } catch (IOException e) {
                // Error occurred when opening raw file for reading.
            } finally {
                contents = stringBuilder.toString();
                setLevel(contents);
            }
        } catch (FileNotFoundException e) {
            gameSave = new File(context.getFilesDir(), "savedata.lk");
            setLevel("Beginner");
        }
    }

    /**
     * Sets the current level the user is  on, or has advanced to. Saves every time
     * user advances a level.
     * @param level level user is on
     */
    public static void setLevel(final String level) {

        try (FileOutputStream fos = context.openFileOutput("savedata.lk", Context.MODE_PRIVATE)) {
            fos.write(level.getBytes());
        } catch (IOException e) {
            //bad
        }
    }

    /**
     * Gets user's current level.
     * @return user's level
     */
    public static String getLevel() {
        try {
            FileInputStream fis = context.openFileInput("savedata.lk");
            InputStreamReader inputStreamReader =
                    new InputStreamReader(fis, StandardCharsets.UTF_8);
            StringBuilder stringBuilder = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(inputStreamReader)) {
                String line = reader.readLine();
                while (line != null) {
                    stringBuilder.append(line).append('\n');
                    line = reader.readLine();
                }
            } catch (IOException e) {
                // Error occurred when opening raw file for reading.
            } finally {
                return stringBuilder.toString().trim();
            }
        } catch (FileNotFoundException e) {
            //bad
        }
        return "";
    }
}
