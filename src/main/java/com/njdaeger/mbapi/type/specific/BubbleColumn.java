package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.BlockType;
import org.bukkit.Location;
import org.bukkit.block.Block;

public abstract class BubbleColumn extends BlockType<BubbleColumn> {
    
    private boolean dragging;
    
    public BubbleColumn(Material<BubbleColumn> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            org.bukkit.block.data.type.BubbleColumn column = (org.bukkit.block.data.type.BubbleColumn)block.getBlockData();
            column.setDrag(dragging);
            block.setBlockData(column);
        }
    }
    
    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }
    
    public boolean isDragging() {
        return dragging;
    }
    
}
