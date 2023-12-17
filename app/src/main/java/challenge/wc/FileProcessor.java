package challenge.wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class FileProcessor {

    public String processFile(String option, File file) throws Exception{
        if (option.equals("-c")) {
            return String.valueOf(calculateFileLength(file));
        } else if (option.equals("-l")) {
            return String.valueOf(calculateLineCount(file));
        } else if (option.equals("-w")) {
            return String.valueOf(calculateWordCount(file));
        } else {
            return "Option parameters accepted: -c,-l";
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

    private Integer calculateWordCount(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return reader.lines()
                .map(line -> line.split(" "))
                .filter(line -> line.length != 0)
                .map(line -> line.length)
                .reduce(0,(a,b) -> a+b);
    }
}
