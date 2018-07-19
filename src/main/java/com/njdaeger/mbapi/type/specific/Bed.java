package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.data.Direction;
import com.njdaeger.mbapi.properties.data.Part;

import java.util.Collections;
import java.util.Set;

public abstract class Bed extends StackedBlockType<Bed> implements Directional<Bed> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean isOccupied;
    private Part part;
    
    public Bed(Material<Bed> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.isOccupied = false;
        this.part = Part.HEAD;
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
    
    public void setPart(Part part) {
        this.part = part;
    }
    
    public Part getPart() {
        return part;
    }
    
    public boolean isOccupied() {
        return isOccupied;
    }
    
}
