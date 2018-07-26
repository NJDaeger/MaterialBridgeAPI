package com.njdaeger.mbapi.exceptions;

import com.njdaeger.mbapi.Material;

public class IncompatibleVersionException extends RuntimeException {
    
    public IncompatibleVersionException(Material<?> constant) {
        super("Version mismatch. Tried to fetch Material " + constant.name() + ". Version " + constant.getVersion().getSupport());
    }
    
}
