package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Bisectable;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Openable;
import com.njdaeger.mbapi.properties.Powerable;
import com.njdaeger.mbapi.properties.Waterloggable;
import com.njdaeger.mbapi.properties.data.Direction;
import com.njdaeger.mbapi.properties.data.Half;

import java.util.Collections;
import java.util.Set;


/*
Properties:

- facing        Directional
- half          Bisectable
- open          Openable
- powered       Powerable
- waterlogged   Waterloggable
 */
public abstract class Trapdoor extends StackedBlockType<Trapdoor> implements Bisectable<Trapdoor>, Directional<Trapdoor>, Powerable<Trapdoor>, Openable<Trapdoor>, Waterloggable<Trapdoor> {
    
    private Half half;
    private Direction direction;
    private boolean powered;
    private boolean open;
    private boolean waterlogged;
    private Set<Direction> allowedDirections;
    
    public Trapdoor(Material<Trapdoor> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.waterlogged = false;
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
    public void setWaterlogged(boolean waterlogged) {
        this.waterlogged = waterlogged;
    }
    
    @Override
    public boolean isWaterlogged() {
        return waterlogged;
    }
}
