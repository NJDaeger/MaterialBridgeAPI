package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Bisectable;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Waterloggable;
import com.njdaeger.mbapi.properties.data.Direction;
import com.njdaeger.mbapi.properties.data.Half;
import com.njdaeger.mbapi.properties.data.StairShape;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.Stairs.Shape;

import java.util.Collections;
import java.util.Set;


/*

Properties:

- facing        Directional
- half          Bisectable
- shape         SELF
- waterlogged   Waterloggable

 */
public abstract class Stairs extends StackedBlockType<Stairs> implements Waterloggable<Stairs>, Directional<Stairs>, Bisectable<Stairs> {
    
    private Set<Direction> allowedDirections;
    private Direction direction;
    private boolean waterlogged;
    private StairShape shape;
    private Half half;
    
    public Stairs(Material<Stairs> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = Direction.NORTH;
        this.waterlogged = false;
        this.shape = StairShape.STRAIGHT;
        this.half = Half.BOTTOM;
    }
    
    @Override
    public void setHalf(Half half) {
        this.half = half;
    }
    
    @Override
    public Half getHalf() {
        return half;
    }
    
    @Override
    public void setDirection(Direction direction) {
        if (isAllowedDirection(direction)) this.direction =  direction;
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
    
    /**
     * Sets the shape of the stairs
     * @param shape The shape of the stairs
     */
    public void setShape(StairShape shape) {
        this.shape = shape;
    }
    
    /**
     * Gets the current shape of the stairs
     * @return The shape of the stairs.
     */
    public StairShape getShape() {
        return shape;
    }
    
    
}
