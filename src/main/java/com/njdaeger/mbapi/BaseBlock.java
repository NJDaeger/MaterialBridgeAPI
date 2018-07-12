package com.njdaeger.mbapi;

import com.njdaeger.mbapi.type.BlockType;

public class BaseBlock<T extends BlockType> {
    
    private final Material<T> material;
    
    public BaseBlock(Material<T> material) {
        this.material = material;
    }
    
    public Material<T> getMaterial() {
        return material;
    }
    
    public T getType() {
        
    }
    
}
