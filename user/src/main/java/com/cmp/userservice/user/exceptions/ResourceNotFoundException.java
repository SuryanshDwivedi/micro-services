package com.cmp.userservice.user.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Resource Not FOUND !!");
    }
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
