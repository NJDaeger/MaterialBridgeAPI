package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Openable;
import com.njdaeger.mbapi.properties.Powerable;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

import java.util.Collections;
import java.util.Set;

/*

Properties:

- facing        Directional
- in_wall       SELF
- open          Openable
- powered       Powerable

 */
public class Gate extends StackedBlockType<Gate> implements Directional<Gate>, Powerable<Gate>, Openable<Gate> {
    
    private Set<BlockFace> allowedDirections;
    private BlockFace direction;
    private boolean powered;
    private boolean inWall;
    private boolean open;
    
    public Gate(Material<Gate> material) {
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
        org.bukkit.block.data.type.Gate gate = (org.bukkit.block.data.type.Gate)block.getBlockData();
        gate.setInWall(inWall);
        gate.setPowered(powered);
        gate.setOpen(open);
        gate.setFacing(direction);
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
    
    @Override
    public void setPowered(boolean powered) {
        this.powered = powered;
    }
    
    @Override
    public boolean isPowered() {
        return powered;
    }
    
    @Override
    public void setOpen(boolean open) {
        this.open = open;
    }
    
    @Override
    public boolean isOpen() {
        return open;
    }
    
    public void setInWall(boolean inWall) {
        this.inWall = inWall;
    }
    
    public boolean isInWall() {
        return inWall;
    }
    
}
