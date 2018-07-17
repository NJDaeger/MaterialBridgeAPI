package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import org.bukkit.block.BlockFace;

import java.util.Set;

public interface MultiDirectional<T extends MaterialType> extends Property<T> {
    
    Set<BlockFace> getDirections();
    
    Set<BlockFace> getAllowedDirections();
    
    void addDirection(BlockFace direction);
    
    void removeDirection(BlockFace direction);
    
    default boolean isAllowedDirection(BlockFace direction) {
        return getAllowedDirections().contains(direction);
    }
    
    default void setNeutral() {
        getDirections().clear();
        addDirection(getAllowedDirections().stream().findFirst().get());
    }
    
    default boolean hasDirection(BlockFace check) {
        return getDirections().contains(check);
    }
    
}
