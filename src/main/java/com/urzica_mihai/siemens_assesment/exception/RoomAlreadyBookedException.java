package com.urzica_mihai.siemens_assesment.exception;

public class RoomAlreadyBookedException extends RuntimeException{
    public RoomAlreadyBookedException(String message){
        super(message);
    };
}
