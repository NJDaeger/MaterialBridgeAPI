package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;

public final class Door extends com.njdaeger.mbapi.type.specific.Door {
    
    public Door(Material<com.njdaeger.mbapi.type.specific.Door> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.Door door = (org.bukkit.block.data.type.Door)block.getBlockData();
            door.setHinge(org.bukkit.block.data.type.Door.Hinge.valueOf(getHinge().name()));
            door.setHalf(Bisected.Half.valueOf(getHalf().name()));
            door.setFacing(BlockFace.valueOf(getDirection().name()));
            door.setOpen(isOpen());
            door.setPowered(isPowered());
            block.setBlockData(door, applyPhysics);
        }
    }
}
