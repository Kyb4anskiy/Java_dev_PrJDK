package ru.kurbatov.oop.any.creatures.humans.Education;

public class InvalidMarkException extends RuntimeException{

    public InvalidMarkException(){
        super();
    }

    public InvalidMarkException(String message){
        super(message);
    }

}
