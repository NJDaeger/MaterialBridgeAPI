package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.Powerable;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

public class Switch extends StackedBlockType<Switch> implements Powerable<Switch>, Directional<Switch> {
    
    private boolean powered;
    private org.bukkit.block.data.type.Switch.Face f;
    private BlockFace direction;
    
    public Switch(Material<Switch> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location) {
    
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
    public void setDirection(BlockFace blockFace) {
    
    }
    
    @Override
    public BlockFace getDirection() {
        return null;
    }
}
