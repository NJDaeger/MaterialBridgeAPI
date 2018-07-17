package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;

public interface Openable<T extends MaterialType> extends Property<T> {
    
    void setOpen(boolean open);
    
    boolean isOpen();
    
}
