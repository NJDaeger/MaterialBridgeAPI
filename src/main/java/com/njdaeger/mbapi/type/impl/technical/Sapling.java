package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;

public final class Sapling extends com.njdaeger.mbapi.type.specific.Sapling {
    
    public Sapling(Material<com.njdaeger.mbapi.type.specific.Sapling> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.Sapling sapling = (org.bukkit.block.data.type.Sapling)block.getBlockData();
            sapling.setStage(getAge());
            block.setBlockData(sapling, applyPhysics);
        }
    }
}
