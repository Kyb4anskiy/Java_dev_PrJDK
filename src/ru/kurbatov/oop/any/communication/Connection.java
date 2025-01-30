package ru.kurbatov.oop.any.communication;

import java.util.Random;

public class Connection{

    private boolean access;
    private final String path;

    public Connection(String path){
        this.path = path;
        access = true;
    }

    public boolean getAccess(){
        return access;
    }

    public String getPath(){
        return path;
    }

    public void closeConnection(){

        access = false;
    }

    public String dataRequest() throws LossOfConnectionException, AlreadyClosedException {
        if (!access) throw new AlreadyClosedException();
        if (new Random().nextInt(2) == 1) throw new LossOfConnectionException("Connection is loss");
        else return "test connection";
    }
}
