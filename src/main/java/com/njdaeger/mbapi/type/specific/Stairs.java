package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Bisectable;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Waterloggable;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected.Half;
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
public class Stairs extends StackedBlockType<Stairs> implements Waterloggable<Stairs>, Directional<Stairs>, Bisectable<Stairs> {
    
    private Set<BlockFace> allowedDirections;
    private BlockFace direction;
    private boolean waterlogged;
    private Shape shape;
    private Half half;
    
    public Stairs(Material<Stairs> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = BlockFace.NORTH;
        this.waterlogged = false;
        this.shape = Shape.STRAIGHT;
        this.half = Half.BOTTOM;
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        Block block = location.getBlock();
        if (!block.getType().equals(getBukkitMaterial())) {
            if (setIfDifferent) block.setType(getBukkitMaterial());
            else return;
        }
        if (MaterialBridge.isPretechnical()) {
            block.setData((byte)getLegacyData().getDurability(), applyPhysics);
            return;
        }
        org.bukkit.block.data.type.Stairs stairs = (org.bukkit.block.data.type.Stairs)block.getBlockData();
        stairs.setShape(shape);
        stairs.setFacing(direction);
        stairs.setHalf(half);
        stairs.setWaterlogged(waterlogged);
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
    public void setDirection(BlockFace direction) {
        if (isAllowedDirection(direction)) this.direction =  direction;
    }
    
    @Override
    public BlockFace getDirection() {
        return direction;
    }
    
    @Override
    public Set<BlockFace> getAllowedDirections() {
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
    public void setShape(Shape shape) {
        this.shape = shape;
    }
    
    /**
     * Gets the current shape of the stairs
     * @return The shape of the stairs.
     */
    public Shape getShape() {
        return shape;
    }
    
    
}
