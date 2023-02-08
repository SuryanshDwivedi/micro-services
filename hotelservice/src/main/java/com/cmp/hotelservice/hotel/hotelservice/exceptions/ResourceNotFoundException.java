package com.cmp.hotelservice.hotel.hotelservice.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Resource Not FOund !!");
    }

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
