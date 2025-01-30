package ru.kurbatov.oop.any.communication;

public class LossOfConnectionException extends Exception{

    public LossOfConnectionException(){
        super();
    }
    public LossOfConnectionException(String message){
        super(message);
    }

    public LossOfConnectionException(Throwable cause){
        super(cause);
    }

    public LossOfConnectionException(String message, Throwable cause){
        super(message, cause);
    }

}
