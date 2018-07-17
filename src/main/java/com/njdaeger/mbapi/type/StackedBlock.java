package com.njdaeger.mbapi.type;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import org.bukkit.Location;

public class StackedBlock extends StackedBlockType<StackedBlock> {
    
    public StackedBlock(Material<StackedBlock> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
    
    }
}
