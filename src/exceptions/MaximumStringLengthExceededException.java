package exceptions;

/**
 * This error extends the class Exception as provided by Java.
 * It is thrown when a string somewhere is too long.
 */
public class MaximumStringLengthExceededException extends Exception {
    public MaximumStringLengthExceededException(String message) {
        super(message);
    }
}
