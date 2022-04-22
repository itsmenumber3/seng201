package exceptions;

/**
 * This error extends the Exception class provided by Java.
 * This error should be thrown when some Monster properties, such as its health,
 * goes below constant MINIMUM_MONSTER_NUMERIC_PROPERTY_VALUE: integer in MagicNumbers
 * or goes above constant MAXIMUM_MONSTER_NUMERIC_PROPERTY_VALUE: integer in MagicNumbers.
 * Can include a message.
 */
public class InvalidMonsterNumericPropertyException extends Exception {
    public InvalidMonsterNumericPropertyException(String message) {
        super(message);
    }
}
