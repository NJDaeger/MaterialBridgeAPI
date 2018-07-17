package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import org.bukkit.block.BlockFace;

import java.util.Set;

public interface Directional<T extends MaterialType> extends Property<T> {

    void setDirection(BlockFace direction);
    
    BlockFace getDirection();
    
    Set<BlockFace> getAllowedDirections();
    
    default boolean isAllowedDirection(BlockFace direction) {
        return getAllowedDirections().contains(direction);
    }
    
    default void setNeutral() {
        setDirection(getAllowedDirections().stream().findFirst().get());
    }
    
    default boolean isDirection(BlockFace direction) {
        return getDirection().equals(direction);
    }
    
}
