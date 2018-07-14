package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

public class Anvil extends StackedBlockType<Anvil> implements Directional<Anvil> {
    
    public Anvil(Material<Anvil> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location) {
    
    }
    
    @Override
    public void setDirection(BlockFace blockFace) {
    
    }
    
    @Override
    public BlockFace getDirection() {
        return null;
    }
}
