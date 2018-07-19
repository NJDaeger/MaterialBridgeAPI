package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;

public final class Pillar extends com.njdaeger.mbapi.type.specific.Pillar {
    
    public Pillar(Material<com.njdaeger.mbapi.type.specific.Pillar> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.Orientable pillar = (org.bukkit.block.data.Orientable)block.getBlockData();
            pillar.setAxis(org.bukkit.Axis.valueOf(getAxis().name()));
            block.setBlockData(pillar, applyPhysics);
        }
    }
}
