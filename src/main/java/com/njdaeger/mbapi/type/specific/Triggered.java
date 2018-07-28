package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.Set;

//todo implement
public abstract class Triggered extends StackedBlockType<Triggered> implements Directional<Triggered> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean triggered;
    
    public Triggered(Material<Triggered> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.triggered = false;
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
    
    public void setTriggered(boolean triggered) {
        this.triggered = triggered;
    }
    
    public boolean isTriggered() {
        return triggered;
    }
    
}
