package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;

public final class Stairs extends com.njdaeger.mbapi.type.specific.Stairs {
    
    public Stairs(Material<com.njdaeger.mbapi.type.specific.Stairs> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.Stairs stairs = (org.bukkit.block.data.type.Stairs)block.getBlockData();
            stairs.setShape(org.bukkit.block.data.type.Stairs.Shape.valueOf(getShape().name()));
            stairs.setFacing(BlockFace.valueOf(getDirection().name()));
            stairs.setHalf(Bisected.Half.valueOf(getHalf().name()));
            stairs.setWaterlogged(isWaterlogged());
            block.setBlockData(stairs, applyPhysics);
        }
    }
}
