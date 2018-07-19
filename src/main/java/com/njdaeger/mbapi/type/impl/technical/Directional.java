package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public final class Directional extends com.njdaeger.mbapi.type.specific.Directional {
    
    public Directional(Material<com.njdaeger.mbapi.type.specific.Directional> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.Directional anvil = (org.bukkit.block.data.Directional)block.getBlockData();
            anvil.setFacing(BlockFace.valueOf(getDirection().name()));
            block.setBlockData(anvil, applyPhysics);
        }
    }
}
