package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.MultiDirectional;
import com.njdaeger.mbapi.properties.Waterloggable;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Fence extends StackedBlockType<Fence> implements MultiDirectional<Fence>, Waterloggable<Fence> {
    
    private Set<BlockFace> allowedDirections;
    private Set<BlockFace> directions;
    private boolean waterlogged;
    
    public Fence(Material<Fence> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        allowedDirections.add(BlockFace.SELF);
        this.directions = new HashSet<>();
        this.directions.add(BlockFace.SELF);
        this.waterlogged = false;
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
        org.bukkit.block.data.type.Fence fence = (org.bukkit.block.data.type.Fence)block.getBlockData();
        if (directions.isEmpty()) directions.add(BlockFace.SELF);
        directions.forEach(direction -> fence.setFace(direction, true));
        fence.setWaterlogged(waterlogged);
        block.setBlockData(fence);
    }
    
    @Override
    public void addDirection(BlockFace direction) {
        if (isAllowedDirection(direction) && !hasDirection(direction)) directions.add(direction);
        
    }
    
    @Override
    public void removeDirection(BlockFace direction) {
        if (hasDirection(direction)) directions.remove(direction);
    }
    
    @Override
    public Set<BlockFace> getDirections() {
        return directions;
    }
    
    @Override
    public Set<BlockFace> getAllowedDirections() {
        return Collections.unmodifiableSet(allowedDirections);
    }
    
    @Override
    public void setWaterlogged(boolean waterlogged) {
        if (MaterialBridge.isPretechnical()) this.waterlogged = false; //Blocks cant be waterlogged in 1.12 down
        else this.waterlogged = waterlogged;
    }
    
    @Override
    public boolean isWaterlogged() {
        return waterlogged;
    }
}
