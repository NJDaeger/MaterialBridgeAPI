package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public final class Switch extends com.njdaeger.mbapi.type.specific.Switch {
    
    public Switch(Material<com.njdaeger.mbapi.type.specific.Switch> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.Switch swch = (org.bukkit.block.data.type.Switch)block.getBlockData();
            swch.setFace(org.bukkit.block.data.type.Switch.Face.valueOf(getFace().name()));
            swch.setFacing(BlockFace.valueOf(getDirection().name()));
            swch.setPowered(isPowered());
            block.setBlockData(swch, applyPhysics);
        }
    }
}
