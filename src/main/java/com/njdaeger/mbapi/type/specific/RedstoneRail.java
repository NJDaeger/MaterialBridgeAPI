package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Powerable;
import com.njdaeger.mbapi.properties.data.RailShape;

/*

Properties:

- RailShape         SELF
- powered       Powerable

 */
public abstract class RedstoneRail extends StackedBlockType<RedstoneRail> implements Powerable<RedstoneRail> {
    
    private RailShape shape;
    private boolean powered;
    
    public RedstoneRail(Material<RedstoneRail> material) {
        super(material);
        this.shape = RailShape.NORTH_SOUTH;
        this.powered = false;
    }
    
    public void setShape(RailShape shape) {
        this.shape = shape;
    }
    
    public RailShape getShape() {
        return shape;
    }
    
    @Override
    public void setPowered(boolean powered) {
        this.powered = powered;
    }
    
    @Override
    public boolean isPowered() {
        return powered;
    }
    
}
