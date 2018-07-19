package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public final class Gate extends com.njdaeger.mbapi.type.specific.Gate {
    
    public Gate(Material<com.njdaeger.mbapi.type.specific.Gate> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.Gate gate = (org.bukkit.block.data.type.Gate)block.getBlockData();
            gate.setInWall(isInWall());
            gate.setPowered(isPowered());
            gate.setOpen(isOpen());
            gate.setFacing(BlockFace.valueOf(getDirection().name()));
            block.setBlockData(gate, applyPhysics);
        }
    }
}
