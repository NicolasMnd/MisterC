package com.misterc.controller;

public abstract class InputType<T> {

    private final T data;

    public InputType(T type) {
        this.data = type;
    }

    public T getData() {
        return this.data;
    }

}
