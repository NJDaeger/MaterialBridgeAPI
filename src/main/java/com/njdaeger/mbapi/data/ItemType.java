package com.njdaeger.mbapi.data;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.properties.Stackable;

/**
 * Represents a material that cannot be placed in the world, but can be obtained through an item stack.
 * @param <T>
 */
public abstract class ItemType<T extends MaterialType> extends MaterialType<T> implements Stackable<T> {
    
    public ItemType(Material<T> material) {
        super(material);
    }
}
