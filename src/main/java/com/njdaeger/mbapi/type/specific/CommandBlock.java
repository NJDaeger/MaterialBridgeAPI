package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.data.Direction;

import java.util.Collections;
import java.util.Set;

//TODO implement
public abstract class CommandBlock extends StackedBlockType<CommandBlock> implements Directional<CommandBlock> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean conditional;
    private String command;
    
    public CommandBlock(Material<CommandBlock> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        allowedDirections.add(Direction.UP);
        allowedDirections.add(Direction.DOWN);
        this.direction = Direction.UP;
        this.conditional = false;
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
    
    public boolean isConditional() {
        return conditional;
    }
    
    public void setConditional(boolean conditional) {
        this.conditional = conditional;
    }
    
    public String getCommand() {
        return command;
    }
    
    public void setCommand(String command) {
        this.command = command;
    }
}
