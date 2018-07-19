package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Bisectable;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Openable;
import com.njdaeger.mbapi.properties.Powerable;
import com.njdaeger.mbapi.properties.data.Direction;
import com.njdaeger.mbapi.properties.data.Half;
import com.njdaeger.mbapi.properties.data.Hinge;

import java.util.Collections;
import java.util.Set;

/*

Properties:

- facing          Directionable
- half            Bisectable
- hinge           SELF
- open            Openable
- powered         Powerable

 */
public abstract class Door extends StackedBlockType<Door> implements Bisectable<Door>, Powerable<Door>, Openable<Door>, Directional<Door> {
    
    private Half half;
    private Hinge hinge;
    private boolean open;
    private boolean powered;
    private Direction direction;
    private Set<Direction> allowedDirections;
    
    
    public Door(Material<Door> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.hinge = Hinge.LEFT;
        this.half = Half.TOP;
        this.powered = false;
        this.open = false;
    }
    
    @Override
    public void setHalf(Half half) {
        this.half = half;
    }
    
    @Override
    public Half getHalf() {
        return half;
    }
    
    @Override
    public void setOpen(boolean open) {
        this.open = open;
    }
    
    @Override
    public boolean isOpen() {
        return open;
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
    
    public void setHinge(Hinge hinge) {
        this.hinge = hinge;
    }
    
    public Hinge getHinge() {
        return hinge;
    }
    
}
