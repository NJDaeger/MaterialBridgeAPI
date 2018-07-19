package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Waterloggable;
import com.njdaeger.mbapi.properties.data.SlabType;

/*

Properties:

- Type              SELF
- Waterlogged       Waterloggable

 */

public abstract class Slab extends StackedBlockType<Slab> implements Waterloggable<Slab> {
    
    private boolean waterlogged;
    private SlabType type;
    
    public Slab(Material<Slab> material) {
        super(material);
        this.type = SlabType.BOTTOM;
        this.waterlogged = false;
    }
    
    public void setType(SlabType type) {
        this.type = type;
    }
    
    public SlabType getType() {
        return type;
    }
    
    @Override
    public void setWaterlogged(boolean waterlogged) {
        this.waterlogged = waterlogged;
    }
    
    @Override
    public boolean isWaterlogged() {
        return waterlogged;
    }
}
