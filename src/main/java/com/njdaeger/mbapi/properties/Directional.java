package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Set;

public interface Directional<T extends MaterialType> extends Property<T> {

    void setDirection(Direction direction);
    
    Direction getDirection();
    
    Set<Direction> getAllowedDirections();
    
    default boolean isAllowedDirection(Direction direction) {
        return getAllowedDirections().contains(direction);
    }
    
    default void setNeutral() {
        setDirection(getAllowedDirections().stream().findFirst().get());
    }
    
    default boolean isDirection(Direction direction) {
        return getDirection().equals(direction);
    }
    
}
