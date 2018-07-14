package com.njdaeger.mbapi.data;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.properties.Stackable;

/**
 * StackedBlockTypes can be placed in the world, and be obtained through an item stack
 * @param <T>
 */
public abstract class StackedBlockType<T extends MaterialType> extends BlockType<T> implements Stackable<T> {
    
    public StackedBlockType(Material<T> material) {
        super(material);
    }
}
