package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.BlockType;
import com.njdaeger.mbapi.properties.Ageable;
import com.njdaeger.mbapi.properties.MultiDirectional;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//todo implement
public abstract class Fire extends BlockType<Fire> implements Ageable<Fire>, MultiDirectional<Fire> {
    
    private Set<Direction> allowedDirections;
    private Set<Direction> directions;
    private int age;
    
    public Fire(Material<Fire> material) {
        super(material);
        this.allowedDirections = Util.allDirectionsExcept();
        this.directions = new HashSet<>();
        directions.add(Direction.SELF);
        this.age = 0;
    }
    
    @Override
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public int getAge() {
        return age;
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
    public void addDirection(Direction direction) {
        if (isAllowedDirection(direction) && !hasDirection(direction)) directions.add(direction);
    }
    
    @Override
    public void removeDirection(Direction direction) {
        if (hasDirection(direction)) directions.remove(direction);
    }
}
