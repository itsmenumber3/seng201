package exceptions;

/**
 * This error extends the Exception class provided by Java.
 * This error should be thrown when validation for a user's input fails.
 * Can include a message.
 */
public class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
