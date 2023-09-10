package com.beginsecure.domain;

public class Counter {
    private int value;
    public Counter(){
        value = 0;
    }
    public Counter(int value){
        if(value<0){
            throw new IllegalArgumentException("Negative value is not allowed!");
        }
        this.value=value;
    }
    public int getValue(){
        return value;
    }
    public void increaseValue(){
        if(value==Integer.MAX_VALUE){
            throw new IllegalStateException("Increasing by one would result in overflow!");
        }
        value++;
    }
    public String toString(){
        return "The value is "+value;
    }

}
