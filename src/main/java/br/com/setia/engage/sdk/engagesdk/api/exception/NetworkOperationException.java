package br.com.setia.engage.sdk.engagesdk.api.exception;

public class NetworkOperationException extends Exception {
    public NetworkOperationException() {
        super();
    }

    public NetworkOperationException(String message) {
        super(message);
    }

    public NetworkOperationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NetworkOperationException(Throwable cause) {
        super(cause);
    }

    protected NetworkOperationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
