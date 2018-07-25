package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Lightable;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.Set;

//todo implement
public abstract class Furnace extends StackedBlockType<Furnace> implements Directional<Furnace>, Lightable<Furnace> {
   
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean lit;
    
    public Furnace(Material<Furnace> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.lit = false;
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
    
    @Override
    public void setLit(boolean lit) {
        this.lit = lit;
    }
    
    @Override
    public boolean isLit() {
        return lit;
    }
}
