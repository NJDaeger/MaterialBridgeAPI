package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.BlockType;
import com.njdaeger.mbapi.properties.Ageable;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.Set;

public abstract class Cocoa extends BlockType<Cocoa> implements Directional<Cocoa>, Ageable<Cocoa> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private int age;
    
    public Cocoa(Material<Cocoa> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
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
}
