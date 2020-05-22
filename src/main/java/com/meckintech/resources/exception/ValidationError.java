package com.meckintech.resources.exception;


import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
    private static final long serialVersionUID = 6945081279837642342L;


    private final List<FieldMessage> list = new ArrayList<>();

    public ValidationError(final Integer status, final String msg, final long timeStamp) {
        super(status, msg, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return this.list;

    }

    public void addError(final String fieldName, final String message) {
        this.list.add(new FieldMessage(fieldName, message));

    }
}
