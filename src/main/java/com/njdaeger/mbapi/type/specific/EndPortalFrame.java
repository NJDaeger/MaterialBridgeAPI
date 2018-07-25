package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.Set;

//todo implement
public abstract class EndPortalFrame extends StackedBlockType<EndPortalFrame> implements Directional<EndPortalFrame> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean eyed;
    
    public EndPortalFrame(Material<EndPortalFrame> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.eyed = false;
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
    
    public void setEyed(boolean eyed) {
        this.eyed = eyed;
    }
    
    public boolean isEyed() {
        return eyed;
    }
    
}
