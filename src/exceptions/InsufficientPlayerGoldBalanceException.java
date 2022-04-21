package exceptions;

public class InsufficientPlayerGoldBalanceException extends Exception {
    public InsufficientPlayerGoldBalanceException(String message) {
        super(message);
    }
}
