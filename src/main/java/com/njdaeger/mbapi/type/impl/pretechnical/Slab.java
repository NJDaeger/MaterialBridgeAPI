package com.njdaeger.mbapi.type.impl.pretechnical;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.properties.data.SlabType;
import org.bukkit.Location;

public final class Slab extends com.njdaeger.mbapi.type.specific.Slab {
    
    public Slab(Material<com.njdaeger.mbapi.type.specific.Slab> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            
            short data = getLegacyData().getDurability(() -> {
                if (getType() == SlabType.DOUBLE) return getLegacyData().getDurability();
                return Short.valueOf(Integer.toString(getType() == SlabType.BOTTOM ? getLegacyData().getDurability() : getLegacyData().getDurability() + 8));
            });
            
            Util.setData(location.getBlock(), data, applyPhysics);
        }
    }
}
