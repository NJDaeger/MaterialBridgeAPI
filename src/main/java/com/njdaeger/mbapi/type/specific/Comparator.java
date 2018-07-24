package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Powerable;
import com.njdaeger.mbapi.properties.data.ComparatorMode;
import com.njdaeger.mbapi.properties.data.Direction;
import org.bukkit.Location;

import java.util.Collections;
import java.util.Set;

//TODO implement
public abstract class Comparator extends StackedBlockType<Comparator> implements Directional<Comparator>, Powerable<Comparator> {
    
    private Set<Direction> allowedDirections;
    private ComparatorMode mode;
    private Direction direction;
    private boolean powered;
    
    public Comparator(Material<Comparator> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.mode = ComparatorMode.COMPARE;
        this.direction = Direction.NORTH;
        this.powered = false;
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
    
    public void setMode(ComparatorMode mode) {
        this.mode = mode;
    }
    
    public ComparatorMode getMode() {
        return mode;
    }
    
}
