package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.data.Direction;
import org.bukkit.OfflinePlayer;

import java.util.Collections;
import java.util.Set;

//todo implement
public abstract class PlayerSkull extends StackedBlockType<PlayerSkull> implements Directional<PlayerSkull> {
    
    private Set<Direction> allowedDirections;
    private OfflinePlayer owningPlayer;
    private Direction direction;
    
    public PlayerSkull(Material<PlayerSkull> material) {
        super(material);
        this.allowedDirections = Util.allDirectionsExcept(Direction.UP, Direction.DOWN, Direction.SELF);
        this.direction = Direction.NORTH;
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
    
    public void setOwningPlayer(OfflinePlayer player) {
        this.owningPlayer = player;
    }
    
    public OfflinePlayer getOwningPlayer() {
        return owningPlayer;
    }
    
}
