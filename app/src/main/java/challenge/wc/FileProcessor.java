package challenge.wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileProcessor {

    public String processFile(String option, File file) throws Exception{
        if (option.equals("-c")) {
            return String.valueOf(calculateFileLength(file));
        } else if (option.equals("l")) {
            return String.valueOf(calculateLineCount(file));
        } else {
            return "Option parameters accepted: -c";
        }
    }

    private long calculateFileLength(File file) {
        return file.length();
    }

    private Integer calculateLineCount(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Integer lines = 0;

        while (reader.readLine() != null) {
            lines++;
        }
        reader.close();

        return lines;

    }
}
