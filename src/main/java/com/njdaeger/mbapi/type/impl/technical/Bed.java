package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

public final class Bed extends com.njdaeger.mbapi.type.specific.Bed {
    
    public Bed(Material<com.njdaeger.mbapi.type.specific.Bed> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.Bed bed = (org.bukkit.block.data.type.Bed)block.getBlockData();
            bed.setPart(org.bukkit.block.data.type.Bed.Part.valueOf(getPart().name()));
            bed.setFacing(BlockFace.valueOf(getDirection().name()));
            block.setBlockData(bed, applyPhysics);
        }
    }
}
