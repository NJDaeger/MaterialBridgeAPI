package com.njdaeger.mbapi.states;

import com.njdaeger.mbapi.type.BlockType;

public interface PowerTransferable<T extends BlockType> extends State<T> {
    
    void setPower(int power);
    
    int getPower();
    
    int getMaxPower();
    
}
