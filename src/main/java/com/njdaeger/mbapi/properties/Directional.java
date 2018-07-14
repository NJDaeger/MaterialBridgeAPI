package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import org.bukkit.block.BlockFace;

public interface Directional<T extends MaterialType> extends Property<T> {

    void setDirection(BlockFace blockFace);
    
    BlockFace getDirection();
    
    default boolean isDirection(BlockFace blockFace) {
        return getDirection().equals(blockFace);
    }
    
}
