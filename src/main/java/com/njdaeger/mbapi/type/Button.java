package com.njdaeger.mbapi.type;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.states.Powerable;

public class Button extends BlockType<Button> implements Powerable<Button> {
    
    private boolean powered;
    
    public Button(Material<Button> material) {
        super(material);
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
