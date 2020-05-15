package com.meckintech.service;

public class DataIntegrityViolationException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataIntegrityViolationException(final String msg) {
        super(msg);

    }

    public DataIntegrityViolationException(final String msg, final Throwable cause) {
        super(msg, cause);

    }


}
