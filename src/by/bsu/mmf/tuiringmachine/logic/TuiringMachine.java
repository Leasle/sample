package by.bsu.mmf.tuiringmachine.logic;

import by.bsu.mmf.tuiringmachine.command.Command;
import by.bsu.mmf.tuiringmachine.exception.TuiringMachineCommandException;
import by.bsu.mmf.tuiringmachine.head.Head;
import by.bsu.mmf.tuiringmachine.reader.Reader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Сергей on 15.02.2016.
 */
public class TuiringMachine {
    public static char[] addOneToNumber(String tapeFileURL){
        String tape = Reader.readFromFile(tapeFileURL).get(0);

        char[] tapeArray = tape.toCharArray();
        Head head = new Head();
        try {
            if (CommandController.checkCommands()){

                while (head.getNumberCommand() != 0) {
                    Command command = CommandController.findCommand(tapeArray[head.getPosition()], head.getNumberCommand());
                    tapeArray = CommandController.executeCommand(tapeArray, head, command);
                }

            } else return tapeArray;
        } catch (TuiringMachineCommandException e) {
            System.out.println("Exception is occurs. " + e.getMessage());
            e.printStackTrace();
            return tapeArray;
        }

        printResult(tapeArray, head);

        return tapeArray;
    }

    private static void printResult(char[] tape, Head head){
        for(char symbol : tape)
            System.out.print(symbol);
        System.out.printf("\n%" + head.getPosition() + "c", '^');
    }
}
