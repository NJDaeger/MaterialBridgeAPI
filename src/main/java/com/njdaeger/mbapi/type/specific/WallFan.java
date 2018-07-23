package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Waterloggable;
import com.njdaeger.mbapi.properties.data.Direction;
import org.bukkit.Location;

import java.util.Collections;
import java.util.Set;

public abstract class WallFan extends StackedBlockType<WallFan> implements Waterloggable<WallFan>, Directional<WallFan> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean waterlogged;
    
    public WallFan(Material<WallFan> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.waterlogged = false;
    }
    
    @Override
    public void setDirection(Direction direction) {
        this.direction = direction;
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
}
