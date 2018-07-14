package com.njdaeger.mbapi;

public class TypeNotCreatedException extends RuntimeException {
    
    public TypeNotCreatedException(String materialName) {
        super("Failed to create type data for " + materialName);
    }
    
}
