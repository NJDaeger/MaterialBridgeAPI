package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.Set;

//todo implement
public abstract class Rotatable extends StackedBlockType<Rotatable> implements Directional<Rotatable> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    
    public Rotatable(Material<Rotatable> material) {
        super(material);
        this.allowedDirections = Util.allDirectionsExcept(Direction.UP, Direction.DOWN, Direction.SELF);
    }
    
    @Override
    public void setDirection(Direction direction) {
        if (isAllowedDirection(direction)) this.direction = direction;
    }
    
    @Override
    public Direction getDirection() {
        return direction;
    }
    
    @Override
    public Set<Direction> getAllowedDirections() {
        return Collections.unmodifiableSet(allowedDirections);
    }
}
