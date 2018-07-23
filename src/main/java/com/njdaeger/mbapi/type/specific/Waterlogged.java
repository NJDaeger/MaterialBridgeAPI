package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Waterloggable;

public abstract class Waterlogged extends StackedBlockType<Waterlogged> implements Waterloggable<Waterlogged> {
    
    private boolean waterlogged;
    
    public Waterlogged(Material<Waterlogged> material) {
        super(material);
        this.waterlogged = false;
    }

    @Override
    public void setWaterlogged(boolean waterlogged) {
        if (MaterialBridge.isPretechnical()) return;
        this.waterlogged = waterlogged;
    }
    
    @Override
    public boolean isWaterlogged() {
        return waterlogged;
    }
    
}
