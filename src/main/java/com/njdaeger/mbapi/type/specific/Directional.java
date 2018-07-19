package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.Set;

/*

Properties:

- facing        Directional

 */
public abstract class Directional extends StackedBlockType<Directional> implements com.njdaeger.mbapi.properties.Directional<Directional> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    
    public Directional(Material<Directional> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
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
