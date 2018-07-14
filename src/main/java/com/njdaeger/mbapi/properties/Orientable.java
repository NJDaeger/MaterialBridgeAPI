package com.njdaeger.mbapi.properties;

import org.bukkit.Axis;

public interface Orientable {
    
    void setAxis(Axis axis);
    
    Axis getAxis();
    
    default boolean isAxis(Axis check) {
        return getAxis().equals(check);
    }
    
}
