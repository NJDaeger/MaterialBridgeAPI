package com.njdaeger.mbapi.data;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.World;

/**
 * Block types can be placed in the world. May or may not be able to be made into an item stack.
 * @param <T>
 */
public abstract class BlockType<T extends MaterialType> extends MaterialType<T>  {
    
    public BlockType(Material<T> material) {
        super(material);
    }
    
    public abstract void setBlock(Location location);
    
    public void setBlock(World world, int x, int y, int z) {
        setBlock(new Location(world, x, y, z));
    }
}
