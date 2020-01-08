package me.ohtaeg.domain.search.exception;

public class NoQueryException extends RuntimeException {
    private static final String ERROR_MESSAGE = "검색어 파라미터 Query 값이 올바르지 않습니다. : '%s')";

    public NoQueryException(final String source) {
        super(String.format(ERROR_MESSAGE, source));
    }
}
