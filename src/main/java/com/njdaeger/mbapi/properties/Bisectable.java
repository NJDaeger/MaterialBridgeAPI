package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.data.MaterialType;
import org.bukkit.block.data.Bisected;

public interface Bisectable<T extends MaterialType> extends Property<T> {
    
    void setHalf(Bisected.Half half);
    
    Bisected.Half getHalf();
    
    default boolean isTop() {
        return getHalf().equals(Bisected.Half.TOP);
    }
    
}
