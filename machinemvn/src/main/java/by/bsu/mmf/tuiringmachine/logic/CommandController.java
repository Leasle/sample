package by.bsu.mmf.tuiringmachine.logic;

import by.bsu.mmf.tuiringmachine.command.Command;
import by.bsu.mmf.tuiringmachine.exception.TuiringMachineCommandException;
import by.bsu.mmf.tuiringmachine.head.Head;
import by.bsu.mmf.tuiringmachine.reader.Reader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Сергей on 18.02.2016.
 */
public class CommandController {
    private static final String COMMAND_FILE_URL = "src/by/bsu/mmf/tuiringmachine/resource/commands";

    public static boolean checkCommands() throws TuiringMachineCommandException {
        List<String> commands = Reader.readFromFile(COMMAND_FILE_URL);

        boolean checking = true;

        String patternCommand = "^(\\w|#)q\\d";
        Pattern pattern = Pattern.compile(patternCommand);

        Set<String> setCommands = new HashSet<String>();

        for (String com : commands){
            Matcher matcher = pattern.matcher(com);
            if (matcher.find()) {
                if (!setCommands.add(matcher.group())) {
                    checking = false;
                    throw new TuiringMachineCommandException("Founded the same commands: " + matcher.group());
                }
            } else { checking = false;
                throw new TuiringMachineCommandException("Commands are incorrect.");
            }
        }
        return checking;
    }

    public static Command findCommand(char symbolB, int commandNumber) throws TuiringMachineCommandException{
        List<String> commands = Reader.readFromFile(COMMAND_FILE_URL);
        Command command = null;

        boolean finding = false;

        String patternString = "^" + symbolB + "q" + commandNumber;
        Pattern pattern = Pattern.compile(patternString);

        for(String com : commands) {
            Matcher matcher = pattern.matcher(com);
            if (matcher.find()) {
                Pattern patternCommand = Pattern.compile("(\\d|#)q\\d(R|L|S)$");
                Matcher matcherCommand = patternCommand.matcher(com);

                String commandString = null;
                if (matcherCommand.find())
                    commandString = matcherCommand.group();

                if (commandString != null) {
                    char symbolA = commandString.charAt(0);
                    int commandNumberA = Integer.parseInt(commandString.charAt(2) + "");
                    char move = commandString.charAt(commandString.length() - 1);

                    command = new Command(symbolB, commandNumber, move, symbolA, commandNumberA);
                }
                finding = true;
                break;
            }
        }

        if (!finding) throw new TuiringMachineCommandException("Command not found: " + symbolB + "q" + commandNumber);

        return command;
    }

    public static char[] executeCommand(char[] tape, Head head, Command command) throws TuiringMachineCommandException {
        if (command != null && head != null && tape != null) {

            if (command.getSymbolB() == tape[head.getPosition()] &&
                    command.getCommandNumberB() == head.getNumberCommand()){

                tape[head.getPosition()] = command.getSymbolA();

                switch(command.getMove()) {
                    case 'L' : head.decreasePosition();
                                break;
                    case 'S' : break;
                    case 'R' : head.increasePosition();
                                break;

                    default: throw new TuiringMachineCommandException("Wrong command.");
                }

                head.setNumberCommand(command.getCommandNumberA());
            } else throw new TuiringMachineCommandException("Wrong command.");
        }

        return tape;
    }
}
