package challenge.wc;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class FileProcessorTest {

    private FileProcessor testFileProcessor;

    private File testFile;
    private final String TEST_FILE_LENGTH = "342190";

    private final String TEST_FILE_LINE_COUNT = "7145";


    @Before
    public void setup() {
        testFileProcessor = new FileProcessor();
        testFile = new File(getClass().getResource("/test.txt").getFile());

    }

    @Test
    public void fileLengthTest() throws Exception {
        String result = testFileProcessor.processFile("-c",testFile);
        assertEquals(TEST_FILE_LENGTH,result);
    }

    @Test
    public void lineCountTest() throws Exception {
        String result = testFileProcessor.processFile("l",testFile);
        assertEquals(TEST_FILE_LINE_COUNT,result);
    }
}
