package ru.alazarev.generic;

public class SimpleArray<T> {
    Object[] models;
    int index = 0;

    public  SimpleArray(int size){
        this.models = new Object[size];
    }

    public void add(T model) {
        this.models[index++] = model;
    }

    public void set(int index, T model) {
        this.models[index] = model;
    }

    public void delete(int index) {
        this.models[index] = "";
    }

    public T get(int index) {
        return (T) this.models[index];
    }
//class Some implements Iterable
//
//    }
//
//    public Iterable<T> Iterable(){
//
//    }
}
