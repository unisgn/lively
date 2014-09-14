package com.lively.exception;

/**
 * Created by franCiS on Sep 14, 2014.
 */
public class LivelyException extends Exception {
    public LivelyException() {
        super();
    }

    public LivelyException(String message) {
        super(message);
    }

    public LivelyException(Throwable cause) {
        super(cause);
    }

    public LivelyException(String message, Throwable cause) {
        super(message,cause);
    }

    public LivelyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message,cause,enableSuppression,writableStackTrace);
    }
}
