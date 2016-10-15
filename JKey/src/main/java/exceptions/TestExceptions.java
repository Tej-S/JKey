package exceptions;

/**
 * Created by Aundre.Jess
 */
public class TestExceptions extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TestExceptions(String message) {
        super(message);
    }

    public TestExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
