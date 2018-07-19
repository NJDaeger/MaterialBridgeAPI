package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.Rail;

public final class RedstoneRail extends com.njdaeger.mbapi.type.specific.RedstoneRail {
    
    public RedstoneRail(Material<com.njdaeger.mbapi.type.specific.RedstoneRail> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.RedstoneRail rail = (org.bukkit.block.data.type.RedstoneRail)block.getBlockData();
            rail.setShape(Rail.Shape.valueOf(getShape().name()));
            rail.setPowered(isPowered());
            block.setBlockData(rail, applyPhysics);
        }
    }
}
