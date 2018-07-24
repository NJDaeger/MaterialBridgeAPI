package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Levelable;

//TODO implement
public abstract class Cauldron extends StackedBlockType<Cauldron> implements Levelable<Cauldron> {
    
    private int level;
    
    public Cauldron(Material<Cauldron> material) {
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
