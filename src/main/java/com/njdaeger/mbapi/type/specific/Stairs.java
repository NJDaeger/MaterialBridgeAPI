package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.data.type.Slab;

public class Stairs extends StackedBlockType<Stairs> {
    
    
    
    public Stairs(Material<Stairs> material) {
        super(material);
        org.bukkit.block.data.type.Stairs s ;
        
        
    }
    
    @Override
    public void setBlock(Location location) {
    
    }
    
    
    
}
