package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {


    public static String extractFileContent(File file) {
        StringBuilder builder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line.toLowerCase());
                builder.append(".\n");
            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

}
