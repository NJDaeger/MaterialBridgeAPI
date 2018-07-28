package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.data.Direction;
import org.bukkit.Location;

import java.util.Set;

public class EndRod extends StackedBlockType<EndRod> implements Directional<EndRod> {
    
    public EndRod(Material<EndRod> material) {
        super(material);
    }
    
    @Override
    public void setDirection(Direction direction) {
    
    }
    
    @Override
    public Direction getDirection() {
        return null;
    }
    
    @Override
    public Set<Direction> getAllowedDirections() {
        return null;
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
    
    }
}
