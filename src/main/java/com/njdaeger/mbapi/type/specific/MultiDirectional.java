package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.data.Direction;
import org.bukkit.Location;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class MultiDirectional extends StackedBlockType<MultiDirectional> implements com.njdaeger.mbapi.properties.MultiDirectional<MultiDirectional> {
    
    private Set<Direction> allowedDirections;
    private Set<Direction> current;
    
    public MultiDirectional(Material<MultiDirectional> material) {
        super(material);
        this.allowedDirections = Util.allDirectionsExcept();
        this.current = new HashSet<>();
        current.add(Direction.SELF);
    }
    
    @Override
    public Set<Direction> getDirections() {
        return current;
    }
    
    @Override
    public Set<Direction> getAllowedDirections() {
        return Collections.unmodifiableSet(allowedDirections);
    }
    
    @Override
    public void addDirection(Direction direction) {
        if (isAllowedDirection(direction)) current.add(direction);
    }
    
    @Override
    public void removeDirection(Direction direction) {
        if (hasDirection(direction)) current.remove(direction);
    }
}
