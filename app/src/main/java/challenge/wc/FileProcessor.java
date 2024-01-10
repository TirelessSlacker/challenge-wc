package challenge.wc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.Buffer;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessor {

    public String processFile(String option, File file) throws Exception {
        if (option.equals("-c")) {
            return String.valueOf(calculateFileLength(file));
        } else if (option.equals("-l")) {
            return String.valueOf(calculateLineCount(file));
        } else if (option.equals("-w")) {
            return String.valueOf(calculateWordCount(file));
        } else if (option.equals("-m")) {
            return String.valueOf(calculateCharacterCount(file));
        } else {
            return "Option parameters accepted: -c,-l,-w,-m";
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
        List<String> result = reader.lines()
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .filter(word -> word.length() > 0)
                .toList();
        return result.size();
    }

    private Integer calculateCharacterCount(File file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return reader.lines()
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .filter(word -> word.length() > 0)
                .flatMap(word -> Stream.of(word.toCharArray()))
                .map(charArray -> charArray.length)
                .reduce(0,(a,b) -> a+b);

    }
}

