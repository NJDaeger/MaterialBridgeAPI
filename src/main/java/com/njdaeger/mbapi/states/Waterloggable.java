package com.njdaeger.mbapi.states;

import com.njdaeger.mbapi.type.BlockType;

public interface Waterloggable<T extends BlockType> extends State<T> {
    
    void setWaterlogged(boolean waterlogged);
    
    boolean isWaterlogged();
    
}
