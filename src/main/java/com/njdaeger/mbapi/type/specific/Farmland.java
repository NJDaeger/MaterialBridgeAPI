package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;

//todo implement
public abstract class Farmland extends StackedBlockType<Farmland> {
    
    private int moisture;
    
    public Farmland(Material<Farmland> material) {
        super(material);
        this.moisture = 0;
    }
    
    public void setMoisture(int moisture) {
        if (moisture > getMaxMoisture()) this.moisture = getMaxMoisture();
        else this.moisture = moisture;
    }
    
    public int getMoisture() {
        return moisture;
    }
    
    public int getMaxMoisture() {
        return 7;
    }
    
}
