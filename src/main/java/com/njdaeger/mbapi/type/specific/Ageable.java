package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;

//TODO implement
public abstract class Ageable extends StackedBlockType<Ageable> implements com.njdaeger.mbapi.properties.Ageable<Ageable> {
    
    private int age;
    
    public Ageable(Material<Ageable> material) {
        super(material);
        this.age = 0;
    }
    
    @Override
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public int getAge() {
        return age;
    }
}
