package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Orientable;
import com.njdaeger.mbapi.properties.data.Axis;

/*
Properties:

- Axis      Orientable
 */
public abstract class Pillar extends StackedBlockType<Pillar> implements Orientable<Pillar> {
    
    private Axis axis;
    
    public Pillar(Material<Pillar> material) {
        super(material);
        this.axis = Axis.Y;
    }
    
    @Override
    public void setAxis(Axis axis) {
        this.axis = axis;
    }
    
    @Override
    public Axis getAxis() {
        return axis;
    }
}
