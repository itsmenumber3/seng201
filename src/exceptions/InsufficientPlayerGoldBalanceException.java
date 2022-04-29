package exceptions;

/**
 * This error extends the class Exception provided by Java.
 * This error should be thrown when the player does not have enough gold balance
 * to purchase an entity. Can include an error message.

 */
public class InsufficientPlayerGoldBalanceException extends Exception {
    public InsufficientPlayerGoldBalanceException(String message) {
        super(message);

    }
}
