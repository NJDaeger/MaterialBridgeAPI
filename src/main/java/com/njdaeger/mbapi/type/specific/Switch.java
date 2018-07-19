package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Powerable;
import com.njdaeger.mbapi.properties.data.Direction;
import com.njdaeger.mbapi.properties.data.Face;

import java.util.Collections;
import java.util.Set;

/*

Properties:

- face      SELF
- facing    Directional
- powered   Powerable

 */

public abstract class Switch extends StackedBlockType<Switch> implements Powerable<Switch>, Directional<Switch> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean powered;
    private Face face;
    
    public Switch(Material<Switch> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.powered = false;
        this.face = Face.WALL;
    }
    
    @Override
    public void setPowered(boolean powered) {
        this.powered = powered;
    }
    
    @Override
    public boolean isPowered() {
        return powered;
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
    
    public void setFace(Face face) {
        this.face = face;
    }
    
    public Face getFace() {
        return face;
    }
    
}
