package com.tw.library.data;

import java.util.Optional;

/**
 * Constructor. Use overloading. 3 constructors
 * 1. With argument of type T indicating success and the return value. Status is set to success, message to empty string and value to the argument.
 * 2. With status and message. value set to empty optional. Status and message set to corresponding arguments.
 * 3. No arguments. Implies success with no return value. status set to success, message to empty string and value to empty Optional.
 */
public class Result<T> {
    private final Status status;
    private final Integer code;
    private final String message;
    private final T value;

    public Result() {
        this.status = Status.SUCCESS;
        this.code = null;
        this.message = "";
        this.value = null;
    }

    public Result(final T value) {
        this.status = Status.SUCCESS;
        this.code = 0;
        this.message = "";
        this.value = value;
    }

    public Result(final Status status, final String message) {
        this.status = status;
        this.code = null;
        this.message = message;
        this.value = null;
    }

    public Result(final Status status, final int code, final String message) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.value = null;
    }

    public Result(final Status status, final String message, final T value) {
        this.status = status;
        this.code = null;
        this.message = message;
        this.value = value;
    }

    public Status getStatus() {
        return this.status;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public T getValue() {
        return this.value;
    }
}
