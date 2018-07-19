package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;

public final class Leaves extends com.njdaeger.mbapi.type.specific.Leaves {
    
    public Leaves(Material<com.njdaeger.mbapi.type.specific.Leaves> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.Leaves leaves = (org.bukkit.block.data.type.Leaves)block.getBlockData();
            leaves.setDistance(getDistance());
            leaves.setPersistent(isPersistent());
            block.setBlockData(leaves, applyPhysics);
        }
    }
}
