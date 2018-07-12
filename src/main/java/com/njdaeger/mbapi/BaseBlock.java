package com.njdaeger.mbapi;

import com.njdaeger.mbapi.type.BlockType;

public class BaseBlock<T extends BlockType> {
    
    public Material material;
    public T type;
    
    public BaseBlock(Material<T> material) {
        this.material = material;
    }
    
    public Material getMaterial() {
        return material;
    }
    
    public T getType() {
        return type;
    }
}
