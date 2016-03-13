package by.bsu.mmf.tuiringmachine.exception;

/**
 * Created by Сергей on 18.02.2016.
 */
public class TuiringMachineCommandException extends Exception {
    public TuiringMachineCommandException() {
    }

    public TuiringMachineCommandException(String s) {
        super(s);
    }

    public TuiringMachineCommandException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public TuiringMachineCommandException(Throwable throwable) {
        super(throwable);
    }

    public TuiringMachineCommandException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
