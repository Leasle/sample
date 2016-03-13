package by.bsu.mmf.tuiringmachine.action;

import by.bsu.mmf.tuiringmachine.logic.TuiringMachine;
import by.bsu.mmf.tuiringmachine.reader.Reader;

import java.util.List;

/**
 * Created by Сергей on 15.02.2016.
 */
public class Runner {
    public static void main(String... args){
        List<String> commands = Reader.readFromFile("src/by/bsu/mmf/tuiringmachine/resource/commands");

        System.out.println(commands.toString());

        TuiringMachine.addOneToNumber("src/by/bsu/mmf/tuiringmachine/resource/tape");
    }
}
