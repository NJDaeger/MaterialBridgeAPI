package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;

public interface Waterloggable<T extends MaterialType> extends Property<T> {
    
    void setWaterlogged(boolean waterlogged);
    
    boolean isWaterlogged();
    
}
