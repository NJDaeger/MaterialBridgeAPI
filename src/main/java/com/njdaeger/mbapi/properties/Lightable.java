package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;

public interface Lightable<T extends MaterialType> extends Property<T> {

    void setLit(boolean lit);
    
    boolean isLit();

}
