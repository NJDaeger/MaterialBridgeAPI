package com.njdaeger.mbapi.exceptions;

import com.njdaeger.mbapi.Material;

public class TypeNotCreatedException extends RuntimeException {
    
    public TypeNotCreatedException(Material<?> material) {
        super("Failed to create type data for " + material.name());
    }
    
}
