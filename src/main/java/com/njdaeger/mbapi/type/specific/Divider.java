package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.MultiDirectional;
import com.njdaeger.mbapi.properties.Waterloggable;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class Divider extends StackedBlockType<Divider> implements MultiDirectional<Divider>, Waterloggable<Divider> {
    
    private Set<Direction> allowedDirections;
    private Set<Direction> directions;
    private boolean waterlogged;
    
    public Divider(Material<Divider> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        allowedDirections.add(Direction.SELF);
        this.directions = new HashSet<>();
        this.directions.add(Direction.SELF);
        this.waterlogged = false;
    }
    
    @Override
    public void addDirection(Direction direction) {
        if (isAllowedDirection(direction) && !hasDirection(direction)) directions.add(direction);
        
    }
    
    @Override
    public void removeDirection(Direction direction) {
        if (hasDirection(direction)) directions.remove(direction);
    }
    
    @Override
    public Set<Direction> getDirections() {
        return directions;
    }
    
    @Override
    public Set<Direction> getAllowedDirections() {
        return Collections.unmodifiableSet(allowedDirections);
    }
    
    @Override
    public void setWaterlogged(boolean waterlogged) {
        if (MaterialBridge.isPretechnical()) this.waterlogged = false; //Blocks cant be waterlogged in 1.12 down
        else this.waterlogged = waterlogged;
    }
    
    @Override
    public boolean isWaterlogged() {
        return waterlogged;
    }
}
