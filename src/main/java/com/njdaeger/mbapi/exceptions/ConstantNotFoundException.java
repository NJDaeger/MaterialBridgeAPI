package com.njdaeger.mbapi.exceptions;

import com.njdaeger.mbapi.Material;

public class ConstantNotFoundException extends RuntimeException {
    
    public ConstantNotFoundException(boolean legacy, String given) {
        super(legacy ? "The legacy constant " + given + " could not be found." : "The constant Material." + given + " was not found.");
    }
    
    public ConstantNotFoundException(String message) {
        super(message);
    }
    
}
