package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;

public abstract class Cake extends StackedBlockType<Cake> {
    
    private int bites;
    
    public Cake(Material<Cake> material) {
        super(material);
    }
    
    public void setBites(int bites) {
        this.bites = bites;
    }
    
    public int getBites() {
        return bites;
    }
    
    public int getMaxBites() {
        return 6;
    }
}
