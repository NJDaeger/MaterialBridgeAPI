package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Ageable;

public abstract class Sapling extends StackedBlockType<Sapling> implements Ageable<Sapling> {
    
    private int age;
    
    public Sapling(Material<Sapling> material) {
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
