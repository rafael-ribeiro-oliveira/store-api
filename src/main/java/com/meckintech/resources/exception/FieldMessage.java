package com.meckintech.resources.exception;


import java.io.Serializable;

public class FieldMessage implements Serializable {
    private static final long serialVersionUID = 805155494431769515L;

    private String fieldName;
    private String message;

    public FieldMessage() {

    }

    public FieldMessage(final String fieldName, final String message) {
        super();
        this.fieldName = fieldName;
        this.message = message;

    }

    public String getFieldName() {
        return this.fieldName;
    }

    public FieldMessage setFieldName(final String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public FieldMessage setMessage(final String message) {
        this.message = message;
        return this;
    }
}
