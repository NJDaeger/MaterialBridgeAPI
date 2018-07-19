package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Openable;
import com.njdaeger.mbapi.properties.Powerable;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.Set;

/*

Properties:

- facing        Directional
- in_wall       SELF
- open          Openable
- powered       Powerable

 */
public abstract class Gate extends StackedBlockType<Gate> implements Directional<Gate>, Powerable<Gate>, Openable<Gate> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean powered;
    private boolean inWall;
    private boolean open;
    
    public Gate(Material<Gate> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.powered = false;
        this.inWall = false;
        this.open = false;
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
    public void setPowered(boolean powered) {
        this.powered = powered;
    }
    
    @Override
    public boolean isPowered() {
        return powered;
    }
    
    @Override
    public void setOpen(boolean open) {
        this.open = open;
    }
    
    @Override
    public boolean isOpen() {
        return open;
    }
    
    public void setInWall(boolean inWall) {
        this.inWall = inWall;
    }
    
    public boolean isInWall() {
        return inWall;
    }
    
}
