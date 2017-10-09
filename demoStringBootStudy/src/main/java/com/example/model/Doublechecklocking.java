package com.example.model;

public class Doublechecklocking {
    private static  volatile  Doublechecklocking instance;
    private Doublechecklocking(){}
    public static Doublechecklocking getInstance(){
        if(instance==null) {
            synchronized (Doublechecklocking.class) {
                if (instance == null) {
                    instance=new Doublechecklocking();
                }
            }
        }
        return instance;
    }
}
