package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.properties.data.Direction;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public final class Fence extends com.njdaeger.mbapi.type.specific.Fence {
    
    public Fence(Material<com.njdaeger.mbapi.type.specific.Fence> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.Fence fence = (org.bukkit.block.data.type.Fence)block.getBlockData();
            if (getDirections().isEmpty()) getDirections().add(Direction.SELF);
            getDirections().forEach(direction -> fence.setFace(BlockFace.valueOf(direction.name()), true));
            fence.setWaterlogged(isWaterlogged());
            block.setBlockData(fence, applyPhysics);
        }
    }
}
