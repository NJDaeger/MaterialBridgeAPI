package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;

/*

Properties:

- Persistent        SELF
- Distance          SELF

 */
public abstract class Leaves extends StackedBlockType<Leaves> {
    
    private boolean persistent;
    private int distance;
    
    public Leaves(Material<Leaves> material) {
        super(material);
        this.persistent = false;
        this.distance = 1;
    }
    
    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
    }
    
    public boolean isPersistent() {
        return persistent;
    }
    
    public void setDistance(int distance) {
        if (distance < 1) distance = 1;
        if (distance > 7) distance = 7;
        this.distance = distance;
    }
    
    public int getDistance() {
        return distance;
    }
    
}
