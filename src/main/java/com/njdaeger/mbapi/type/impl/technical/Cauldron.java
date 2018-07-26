package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.Levelled;

public class Cauldron extends com.njdaeger.mbapi.type.specific.Cauldron {
    
    public Cauldron(Material<com.njdaeger.mbapi.type.specific.Cauldron> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            Levelled levelled = (Levelled)block.getBlockData();
            levelled.setLevel(getLevel());
            block.setBlockData(levelled, applyPhysics);
        }
    }
}
