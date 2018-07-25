package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;

//todo implement
public abstract class Snowable extends StackedBlockType<Snowable> implements com.njdaeger.mbapi.properties.Snowable<Snowable> {
    
    private boolean snowy;
    
    public Snowable(Material<Snowable> material) {
        super(material);
        this.snowy = false;
    }
    
    @Override
    public void setSnowy(boolean snowy) {
        this.snowy = snowy;
    }
    
    @Override
    public boolean isSnowy() {
        return snowy;
    }
}
