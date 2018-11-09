package com.wj.exception;

public class BusinessException extends RuntimeException {

    protected String code;
    protected  String message;
    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String code, String message, Throwable t) {
        super(message, t);
        this.code = code;
        this.message = message;
    }

    public BusinessException(String message, Throwable t) {
        super(message, t);
        this.message = message;
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }
}
