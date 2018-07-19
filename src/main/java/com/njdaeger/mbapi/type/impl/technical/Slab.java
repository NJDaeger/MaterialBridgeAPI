package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;

public final class Slab extends com.njdaeger.mbapi.type.specific.Slab {
    
    public Slab(Material<com.njdaeger.mbapi.type.specific.Slab> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.Slab slab = (org.bukkit.block.data.type.Slab)block.getBlockData();
            slab.setType(org.bukkit.block.data.type.Slab.Type.valueOf(getType().name()));
            slab.setWaterlogged(isWaterlogged());
            block.setBlockData(slab, applyPhysics);
        }
    }
}
