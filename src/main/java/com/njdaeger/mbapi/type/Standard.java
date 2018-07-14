package com.njdaeger.mbapi.type;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.BlockType;
import org.bukkit.Location;

public class Standard extends BlockType<Standard> {
    
    public Standard(Material<Standard> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location) {
    
    }
}
