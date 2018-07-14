package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.MultiDirectional;
import com.njdaeger.mbapi.properties.Waterloggable;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.HashSet;
import java.util.Set;

public class Fence extends StackedBlockType<Fence> implements MultiDirectional<Fence>, Waterloggable<Fence> {
    
    private Set<BlockFace> directions;
    private boolean waterlogged;
    
    public Fence(Material<Fence> material) {
        super(material);
        this.directions = new HashSet<>();
        this.waterlogged = false;
    }
    
    @Override
    public void setBlock(Location location) {
        if (MaterialBridge.isPretechnical()) {
            Block block = location.getBlock();
            if (!block.getType().equals(getBukkitMaterial())) block.setType(getBukkitMaterial());
            org.bukkit.block.data.type.Fence fence = (org.bukkit.block.data.type.Fence)block.getBlockData();
            directions.forEach(direction -> fence.setFace(direction, true));
            fence.setWaterlogged(waterlogged);
            block.setData(fence);
        }
        //todo 1.12 implementation
    }
    
    @Override
    public void addDirection(BlockFace direction) {
        switch (direction) {
            case NORTH:
            case SOUTH:
            case EAST:
            case WEST:
            case SELF:
                if (!hasDirection(direction)) directions.add(direction);
            default:
                setNeutral();
        }
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
    public void setWaterlogged(boolean waterlogged) {
        if (MaterialBridge.isPretechnical()) this.waterlogged = false; //Blocks cant be waterlogged in 1.12 down
        else this.waterlogged = waterlogged;
    }
    
    @Override
    public boolean isWaterlogged() {
        return waterlogged;
    }
}
