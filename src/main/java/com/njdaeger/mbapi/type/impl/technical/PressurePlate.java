package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;

public final class PressurePlate extends com.njdaeger.mbapi.type.specific.PressurePlate {
    
    public PressurePlate(Material<com.njdaeger.mbapi.type.specific.PressurePlate> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.Powerable plate = (org.bukkit.block.data.Powerable)block.getBlockData();
            plate.setPowered(isPowered());
            block.setBlockData(plate, applyPhysics);
        }
    }
}
