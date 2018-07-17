package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.Collections;
import java.util.Set;

/*

Properties:

- facing        Directional

 */
public class Directional extends StackedBlockType<Directional> implements com.njdaeger.mbapi.properties.Directional<Directional> {
    
    private Set<BlockFace> allowedDirections;
    private BlockFace direction;
    
    public Directional(Material<Directional> material) {
        super(material);
        this.allowedDirections = Util.mainDirections();
        this.direction = BlockFace.NORTH;
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
        org.bukkit.block.data.Directional anvil = (org.bukkit.block.data.Directional)block.getBlockData();
        anvil.setFacing(direction);
        block.setBlockData(anvil, applyPhysics);
    }
    
    @Override
    public void setDirection(BlockFace direction) {
        if (isAllowedDirection(direction)) this.direction = direction;
    }
    
    @Override
    public BlockFace getDirection() {
        return direction;
    }
    
    @Override
    public Set<BlockFace> getAllowedDirections() {
        return Collections.unmodifiableSet(allowedDirections);
    }
}
