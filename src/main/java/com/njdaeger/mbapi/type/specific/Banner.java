package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

public class Banner extends StackedBlockType<Banner> implements Directional<Banner> {
    
    public Banner(Material<Banner> material) {
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
