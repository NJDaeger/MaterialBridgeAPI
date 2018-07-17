package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.data.StackedBlockType;
import org.bukkit.Location;
import org.bukkit.block.Block;

/*

Properties:

- Persistent        SELF
- Distance          SELF

 */
public class Leaves extends StackedBlockType<Leaves> {
    
    private boolean persistent;
    private int distance;
    
    public Leaves(Material<Leaves> material) {
        super(material);
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
        org.bukkit.block.data.type.Leaves leaves = (org.bukkit.block.data.type.Leaves)block.getBlockData();
        leaves.setDistance(distance);
        leaves.setPersistent(persistent);
        block.setBlockData(leaves);
    }
    
    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
    }
    
    public boolean isPersistent() {
        return persistent;
    }
    
    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public int getDistance() {
        return distance;
    }
    
}
