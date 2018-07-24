package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Waterloggable;
import com.njdaeger.mbapi.properties.data.ChestType;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.Set;

//TODO implement
public abstract class Chest extends StackedBlockType<Chest> implements Directional<Chest>, Waterloggable<Chest> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean waterlogged;
    private ChestType chestType;
    
    public Chest(Material<Chest> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.chestType = ChestType.SINGLE;
        this.direction = Direction.NORTH;
        this.waterlogged = false;
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
    public void setWaterlogged(boolean waterlogged) {
        this.waterlogged = waterlogged;
    }
    
    @Override
    public boolean isWaterlogged() {
        return waterlogged;
    }
    
    public ChestType getChestType() {
        return chestType;
    }
    
    public void setChestType(ChestType chestType) {
        this.chestType = chestType;
    }
    
}
