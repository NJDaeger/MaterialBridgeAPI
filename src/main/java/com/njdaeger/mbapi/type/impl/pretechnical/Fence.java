package com.njdaeger.mbapi.type.impl.pretechnical;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import org.bukkit.Location;

public final class Fence extends com.njdaeger.mbapi.type.specific.Fence {
    
    public Fence(Material<com.njdaeger.mbapi.type.specific.Fence> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Util.setData(location.getBlock(),getLegacyData(), applyPhysics);
        }
    }
}
