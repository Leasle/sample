package by.bsu.mmf.tuiringmachine.command;

/**
 * Created by Сергей on 18.02.2016.
 */
public class Command {
    private char symbolB;
    private int commandNumberB;
    private char move;
    private char symbolA;
    private int commandNumberA;

    public Command(char symbolB, int commandNumberB, char move, char symbolA, int commandNumberA) {
        this.symbolB = symbolB;
        this.commandNumberB = commandNumberB;
        this.move = move;
        this.symbolA = symbolA;
        this.commandNumberA = commandNumberA;
    }

    public char getSymbolB() {
        return symbolB;
    }

    public int getCommandNumberB() {
        return commandNumberB;
    }

    public char getMove() {
        return move;
    }

    public char getSymbolA() {
        return symbolA;
    }

    public int getCommandNumberA() {
        return commandNumberA;
    }
}
