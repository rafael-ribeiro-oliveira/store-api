package com.meckintech.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String msg;
    private long TimeStamp;

    public StandardError(final Integer status, final String msg, final long timeStamp) {
        this.status = status;
        this.msg = msg;
        this.TimeStamp = timeStamp;
    }

    public Integer getStatus() {
        return this.status;
    }

    public StandardError setStatus(final Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public StandardError setMsg(final String msg) {
        this.msg = msg;
        return this;
    }

    public long getTimeStamp() {
        return this.TimeStamp;
    }

    public StandardError setTimeStamp(final long timeStamp) {
        this.TimeStamp = timeStamp;
        return this;
    }
}
