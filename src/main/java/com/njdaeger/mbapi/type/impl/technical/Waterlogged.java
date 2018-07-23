package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;

public final class Waterlogged extends com.njdaeger.mbapi.type.specific.Waterlogged {
    
    public Waterlogged(Material<com.njdaeger.mbapi.type.specific.Waterlogged> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.Waterlogged waterlogged = (org.bukkit.block.data.Waterlogged)block.getBlockData();
            waterlogged.setWaterlogged(isWaterlogged());
            block.setBlockData(waterlogged, applyPhysics);
        }
    }
}
