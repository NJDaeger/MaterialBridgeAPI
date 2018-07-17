package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import org.bukkit.Axis;

public interface Orientable<T extends MaterialType> extends Property<T> {
    
    void setAxis(Axis axis);
    
    Axis getAxis();
    
    default boolean isAxis(Axis check) {
        return getAxis().equals(check);
    }
    
}
