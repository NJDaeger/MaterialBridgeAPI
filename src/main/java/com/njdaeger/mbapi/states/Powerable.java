package com.njdaeger.mbapi.states;

import com.njdaeger.mbapi.BaseBlock;
import com.njdaeger.mbapi.type.BlockType;

public interface Powerable<T extends BlockType> extends State<T> {
    
    void setPowered(boolean powered);
    
    boolean isPowered();
    
}
