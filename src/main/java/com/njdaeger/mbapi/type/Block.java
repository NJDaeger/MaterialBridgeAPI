package com.njdaeger.mbapi.type;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.BlockType;
import org.bukkit.Location;

/**
 * Can be placed in the world.
 * <p>
 * <p><b>* Cannot be made into an itemstack</p>
 * <p><b>* Has no special properties.
 */
public final class Block extends BlockType<Block> {
    
    public Block(Material<Block> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        org.bukkit.block.Block block = location.getBlock();
        if (!block.getType().equals(asBukkit())) {
            if (setIfDifferent) block.setType(asBukkit(), applyPhysics);
            else return;
        }
        if (MaterialBridge.isPretechnical()) {
            Util.setData(block, getLegacyData().getDurability(), applyPhysics);
            return;
        }
        block.setType(asBukkit(), applyPhysics);//block has no special properties, we can just set it to its proper type in 1.13
    }
}
