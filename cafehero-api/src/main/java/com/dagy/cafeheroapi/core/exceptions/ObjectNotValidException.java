package com.dagy.cafeheroapi.core.exceptions;

import lombok.Data;

import java.util.Set;

@Data
public class ObjectNotValidException extends RuntimeException {

    private final Set<Object> fields;
    private final Set<String> errorMessages;
}
