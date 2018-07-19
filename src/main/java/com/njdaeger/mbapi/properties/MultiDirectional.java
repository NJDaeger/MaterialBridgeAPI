package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import com.njdaeger.mbapi.properties.data.Direction;
import org.bukkit.block.BlockFace;

import java.util.Set;

public interface MultiDirectional<T extends MaterialType> extends Property<T> {
    
    Set<Direction> getDirections();
    
    Set<Direction> getAllowedDirections();
    
    void addDirection(Direction direction);
    
    void removeDirection(Direction direction);
    
    default boolean isAllowedDirection(Direction direction) {
        return getAllowedDirections().contains(direction);
    }
    
    default void setNeutral() {
        getDirections().clear();
        addDirection(getAllowedDirections().stream().findFirst().get());
    }
    
    default boolean hasDirection(Direction check) {
        return getDirections().contains(check);
    }
    
}
