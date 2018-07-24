package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.BlockType;
import com.njdaeger.mbapi.properties.Ageable;

//TODO implement
public abstract class AgeableBlock extends BlockType<AgeableBlock> implements Ageable<AgeableBlock> {
    
    private int age;
    
    public AgeableBlock(Material<AgeableBlock> material) {
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
