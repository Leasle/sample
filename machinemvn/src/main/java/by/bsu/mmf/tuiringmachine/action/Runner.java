package by.bsu.mmf.tuiringmachine.action;

import by.bsu.mmf.tuiringmachine.logic.TuiringMachine;
import by.bsu.mmf.tuiringmachine.reader.Reader;

import java.util.List;

/**
 * Created by Сергей on 15.02.2016.
 */
public class Runner {
    public static void main(String... args){
        List<String> commands = Reader.readFromFile("machinemvn/src/main/resources/commands");

        System.out.println(commands.toString());

        TuiringMachine.addOneToNumber("machinemvn/src/main/resources/tape");
    }
}
