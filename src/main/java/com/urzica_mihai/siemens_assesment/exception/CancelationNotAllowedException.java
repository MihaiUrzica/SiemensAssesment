package com.urzica_mihai.siemens_assesment.exception;

public class CancelationNotAllowedException extends RuntimeException{
    public CancelationNotAllowedException(String message){
        super(message);
    }
}
