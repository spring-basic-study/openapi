package exception;

public class InvalidUrlException extends RuntimeException {
    private static final String ERROR_MESSAGE = "URL이 올바르지 않습니다. : '%s')";

    public InvalidUrlException(final String source) {
        super(String.format(ERROR_MESSAGE, source));
    }
}
