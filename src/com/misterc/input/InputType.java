package com.misterc.input;

public class InputType<T> {

    private final T data;

    public InputType(T type) {
        this.data = type;
    }

    public T getData() {
        return this.data;
    }

}
