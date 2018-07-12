package com.njdaeger.mbapi.states;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.type.BlockType;

public interface State<T extends BlockType> {

    Material<T> getMaterial();
    
}
