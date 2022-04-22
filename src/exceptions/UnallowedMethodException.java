package exceptions;

/**
 * This error extends Exception class provided by Java.
 * This error should be thrown when developer tries to access a prohibited method, such as trying to set the playerPoints directly
 * through setPlayerPoints, which can lead to the game malfunctioning if a wrong value is set.
 */
public class UnallowedMethodException extends Exception {
    public UnallowedMethodException(String message) {
        super(message);
    }
}

