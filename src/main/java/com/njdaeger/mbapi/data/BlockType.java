package com.njdaeger.mbapi.data;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.properties.Placeable;
import org.bukkit.Location;
import org.bukkit.block.Block;

/**
 * Block types can be placed in the world. May or may not be able to be made into an item stack.
 * @param <T>
 */
public abstract class BlockType<T extends MaterialType> extends MaterialType<T> implements Placeable<T> {
    
    public BlockType(Material<T> material) {
        super(material);
    }
    
    protected boolean isValid(Location location, boolean setIfDifferent, boolean applyPhysics) {
        Block block = location.getBlock();
        if (asBukkit() == null) return false;
        if (!block.getType().equals(asBukkit())) {
            if (setIfDifferent) {
                block.setType(asBukkit(), applyPhysics);
                return true;
            }
        }
        return false;
    }
    
}
