package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.MaterialType;

public interface Property<T extends MaterialType> {

    Material<T> getMaterial();
    
}
