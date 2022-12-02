package com.chapaar.crud.exception;

public class NotFoundException extends Exception {

    private static final long serialVersionUID = 2L;

    public NotFoundException(String msg) {
        super(msg);
    }
}
