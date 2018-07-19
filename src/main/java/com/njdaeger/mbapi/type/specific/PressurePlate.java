package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Powerable;

public abstract class PressurePlate extends StackedBlockType<PressurePlate> implements Powerable<PressurePlate> {
    
    private boolean powered;
    
    public PressurePlate(Material<PressurePlate> material) {
        super(material);
        this.powered = false;
    }
    
    @Override
    public void setPowered(boolean powered) {
        this.powered = powered;
    }
    
    @Override
    public boolean isPowered() {
        return powered;
    }
}
