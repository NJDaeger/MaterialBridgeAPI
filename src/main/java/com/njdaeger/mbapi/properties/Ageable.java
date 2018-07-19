package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;

public interface Ageable<T extends MaterialType> extends Property<T> {
    
    void setAge(int age);
    
    int getAge();
    
}
