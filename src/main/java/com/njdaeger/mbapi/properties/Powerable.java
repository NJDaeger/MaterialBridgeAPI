package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;

public interface Powerable<T extends MaterialType> extends Property<T> {
    
    void setPowered(boolean powered);
    
    boolean isPowered();
    
}
