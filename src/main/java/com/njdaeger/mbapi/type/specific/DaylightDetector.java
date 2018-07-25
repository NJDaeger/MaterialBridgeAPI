package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.PowerTransferable;

//todo implement
public abstract class DaylightDetector extends StackedBlockType<DaylightDetector> implements PowerTransferable<DaylightDetector> {
    
    private int power;
    
    public DaylightDetector(Material<DaylightDetector> material) {
        super(material);
        this.power = 0;
    }
    
    @Override
    public void setPower(int power) {
        if (power > getMaxPower()) this.power = getMaxPower();
        else this.power = power;
    }
    
    @Override
    public int getPower() {
        return power;
    }
    
    @Override
    public int getMaxPower() {
        return 15;
    }
}
