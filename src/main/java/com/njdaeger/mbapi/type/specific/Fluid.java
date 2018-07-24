package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.BlockType;
import com.njdaeger.mbapi.properties.Levelable;

//TODO implement
public abstract class Fluid extends BlockType<Fluid> implements Levelable<Fluid> {
    
    private int level;
    
    public Fluid(Material<Fluid> material) {
        super(material);
        this.level = 0;
    }
    
    @Override
    public void setLevel(int level) {
        this.level = level;
    }
    
    @Override
    public int getLevel() {
        return level;
    }
}
