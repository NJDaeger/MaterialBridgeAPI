package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import org.bukkit.block.BlockFace;

import java.util.Set;

public interface MultiDirectional<T extends MaterialType> extends Property<T> {
    
    void addDirection(BlockFace direction);
    
    void removeDirection(BlockFace direction);
    
    Set<BlockFace> getDirections();
    
    default void setNeutral() {
        getDirections().clear();
        addDirection(BlockFace.SELF);
    }
    
    default boolean hasDirection(BlockFace check) {
        return getDirections().contains(check);
    }
    
}
