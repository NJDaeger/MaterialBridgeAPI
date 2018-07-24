package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;

public interface Levelable<T extends MaterialType> extends Property<T> {
    
    void setLevel(int level);
    
    int getLevel();
    
}
