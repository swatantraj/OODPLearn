package com.creation.factory;

public class Server extends Computer{
    private int ram;
    private int storage;
    private float processor;


    public Server(int ram, int storage, float processor){
        this.ram = ram;
        this.storage= storage;
        this.processor = processor;
    }
    public int getRam(){
        return  this.ram;
    }
    public int getStorage(){
        return this.storage;
    }

    public float getProcessor(){
        return  this.processor;
    }
}