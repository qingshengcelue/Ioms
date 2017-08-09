package com.hy.ioms.utils.rx.exception;

/**
 * Created by wsw on 2017/6/2.
 */

public class EmptyException extends RuntimeException {

    public EmptyException() {
    }

    public EmptyException(String message) {
        super(message);
    }

    public EmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyException(Throwable cause) {
        super(cause);
    }

    public EmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
