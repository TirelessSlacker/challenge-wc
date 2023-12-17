/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package challenge.wc;

import java.io.File;

public class App {

    public static void main(String[] args) {
        try {
            if (args.length == 2) {

                File file = new File(args[1]);
                FileProcessor fileProcessor = new FileProcessor();
                System.out.println(fileProcessor.processFile(args[0],file));
            } else {
                System.out.println("This program accepts exactly two inputs!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
