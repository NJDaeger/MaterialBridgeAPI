package com.njdaeger.mbapi.type;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.BlockType;
import org.bukkit.Axis;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

/**
 * Can be placed in the world.
 * <p>
 * <p><b>* Cannot be made into an itemstack</p>
 * <p><b>* Has no special properties.
 */
@SuppressWarnings("unused")
public class Block extends BlockType<Block> {
    
    public Block(Material<Block> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location) {
    
    }
}
