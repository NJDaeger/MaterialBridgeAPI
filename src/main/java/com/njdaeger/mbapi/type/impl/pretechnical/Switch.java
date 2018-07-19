package com.njdaeger.mbapi.type.impl.pretechnical;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import org.bukkit.Location;

public final class Switch extends com.njdaeger.mbapi.type.specific.Switch {
    
    public Switch(Material<com.njdaeger.mbapi.type.specific.Switch> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Util.setData(location.getBlock(), getLegacyData(), applyPhysics);
        }
    }
}
