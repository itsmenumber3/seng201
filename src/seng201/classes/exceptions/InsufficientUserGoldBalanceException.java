package seng201.classes.exceptions;

public class InsufficientUserGoldBalanceException extends Exception {
    public InsufficientUserGoldBalanceException(String message) {
        super(message);
    }
}
