package exceptions;

/**
 * This error extends the Exception class as provided by Java.
 * This error should be thrown where a negative number is not valid as argument.
 * This error should only be used when it is clearly illogical for a property or value to be under 0 or in increments/decrements.
 * If it's an error to do with user input validation, use InvalidInputException instead.
 * If it's an error to do with invalid monster properties, use Invalid MonsterNumericPropertyException
 * @see InvalidInputException
 * @see InvalidMonsterNumericPropertyException
 */
public class UnexpectedNegativeNumberException extends Exception {
    public UnexpectedNegativeNumberException(String message) {
        super(message);
    }
}