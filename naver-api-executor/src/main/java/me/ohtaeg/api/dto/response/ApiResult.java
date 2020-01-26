package me.ohtaeg.api.dto.response;

public class ApiResult<T> {

    private final boolean success;

    private final T response;

    private ApiResult(boolean success, T response) {
        this.success = success;
        this.response = response;
    }

    public static <T> ApiResult<T> OK(T response) {
        return new ApiResult<>(true, response);
    }

    public boolean isSuccess() {
        return success;
    }

    public T getResponse() {
        return response;
    }

    @Override
    public String toString() {
        return "ApiResult{" +
                "success=" + success +
                ", response=" + response +
                '}';
    }
}
