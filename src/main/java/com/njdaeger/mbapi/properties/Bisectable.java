package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import com.njdaeger.mbapi.properties.data.Half;

public interface Bisectable<T extends MaterialType> extends Property<T> {
    
    void setHalf(Half half);
    
    Half getHalf();
    
    default boolean isTop() {
        return getHalf().equals(Half.TOP);
    }
    
}
