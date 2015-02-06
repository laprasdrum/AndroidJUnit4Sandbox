package com.laprasdrum.audioresearch;

import android.content.Context;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileResource {
    private static final int DEFAULT = 0;

    public static void mkFile(Context context, int amount, File folder) {
        mkFile(context, amount, folder, DEFAULT);
    }

    private static void mkFile(Context context, int amount, File folder, int option) {
        switch (option) {
            case DEFAULT:
                try {
                    // TODO: Android において指定したディレクトリにファイルを追加するやり方とテスト方法を調査する
                    FileOutputStream outputStream = context.openFileOutput("UnitTest", Context.MODE_PRIVATE);
                    File unitTestFile = new File(folder, "UnitTest");
                    if (amount > 1) {
                        File readme = new File(folder, "readme.txt");
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
