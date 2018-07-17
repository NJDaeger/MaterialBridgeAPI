package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import org.bukkit.Location;
import org.bukkit.World;

public interface Placeable<T extends MaterialType> extends Property<T> {
    
    void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics);
    
    default void setBlock(Location location, boolean setIfDifferent) {
        setBlock(location, setIfDifferent, true);
    }
    
    default void setBlock(World world, int x, int y, int z, boolean setIfDifferent, boolean applyPhysics) {
        setBlock(new Location(world, x, y, z), setIfDifferent, applyPhysics);
    }
    
    default void setBlock(World world, int x, int y, int z, boolean setIfDifferent) {
        setBlock(world, x, y, z, setIfDifferent, true);
    }
    
    default void setBlock(World world, int x, int y, int z) {
        setBlock(world, x, y, z, true);
    }
    
    default void setBlock(Location location) {
        setBlock(location, true);
    }
    
}
