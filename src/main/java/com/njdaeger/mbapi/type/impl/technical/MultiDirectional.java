package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.MultipleFacing;

public final class MultiDirectional extends com.njdaeger.mbapi.type.specific.MultiDirectional {
    
    public MultiDirectional(Material<com.njdaeger.mbapi.type.specific.MultiDirectional> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            MultipleFacing multi = (MultipleFacing)block.getBlockData();
            getDirections().forEach(f -> multi.setFace(BlockFace.valueOf(f.name()), true));
            block.setBlockData(multi, applyPhysics);
        }
    }
}
