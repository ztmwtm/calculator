package calculator.calculator.exception;

public class ZeroArgumentException extends IllegalArgumentException {
    public ZeroArgumentException() {
    }

    public ZeroArgumentException(String s) {
        super(s);
    }

    public ZeroArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public ZeroArgumentException(Throwable cause) {
        super(cause);
    }
}
