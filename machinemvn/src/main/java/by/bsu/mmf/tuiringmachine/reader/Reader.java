package by.bsu.mmf.tuiringmachine.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Сергей on 15.02.2016.
 */
public class Reader {
    public static List<String> readFromFile(String fileURL){

        List<String> strings = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File(fileURL));
            while(scanner.hasNextLine())
                strings.add(scanner.nextLine());
        } catch (FileNotFoundException ex) {
            System.out.println("Reader. File not found." + ex);
        }

        return strings;
    }
}
