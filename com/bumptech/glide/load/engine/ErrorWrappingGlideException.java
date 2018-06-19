package com.bumptech.glide.load.engine;

public class ErrorWrappingGlideException extends Exception {
    public ErrorWrappingGlideException(Error error) {
        super(error);
        if (error == null) {
            throw new NullPointerException("The causing error must not be null");
        }
    }

    public Error getCause() {
        return (Error) super.getCause();
    }
}
