package com.meckintech.resource.exception;

import org.apache.catalina.filters.AddDefaultCharsetFilter;

import java.io.Serializable;

public class StandardError implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String msg;
    private long TimeStamp;

    public StandardError(Integer status, String msg, long timeStamp) {
        this.status = status;
        this.msg = msg;
        TimeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public StandardError setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public StandardError setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public long getTimeStamp() {
        return TimeStamp;
    }

    public StandardError setTimeStamp(long timeStamp) {
        TimeStamp = timeStamp;
        return this;
    }
}
