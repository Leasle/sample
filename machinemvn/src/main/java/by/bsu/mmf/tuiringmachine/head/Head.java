package by.bsu.mmf.tuiringmachine.head;

/**
 * Created by Сергей on 18.02.2016.
 */
public class Head {
    private int position;
    private int numberCommand;

    public Head() {
        position = 1;
        numberCommand = 1;
    }

    public int getPosition() {
        return position;
    }

    public void increasePosition() {
        this.position++;
    }

    public void decreasePosition() {
        this.position--;
    }

    public int getNumberCommand() {
        return numberCommand;
    }

    public void setNumberCommand(int numberCommand) {
        this.numberCommand = numberCommand;
    }
}
