package com.njdaeger.mbapi.type;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import org.bukkit.Location;

public final class StackedBlock extends StackedBlockType<StackedBlock> {
    
    public StackedBlock(Material<StackedBlock> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            org.bukkit.block.Block block = location.getBlock();
            if (MaterialBridge.isPretechnical()) {
                Util.setData(block, getLegacyData().getDurability(), applyPhysics);
                return;
            }
            block.setType(asBukkit(), applyPhysics);//block has no special properties, we can just set it to its proper type in 1.13
        }
    }
}
