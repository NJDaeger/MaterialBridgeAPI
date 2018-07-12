package com.njdaeger.mbapi.type;

import com.njdaeger.mbapi.LegacyData;
import com.njdaeger.mbapi.Material;

public abstract class BlockType<T extends BlockType> {
    
    private final Material<T> material;
    
    public BlockType(Material<T> material) {
        this.material = material;
    }
    
    public Material<T> getMaterial() {
        return material;
    }
    
    public int getMaxStackSize() {
        return material.getMaxStackSize();
    }
    
    public boolean hasLegacyData() {
        return material.hasLegacyData();
    }
    
    public LegacyData getLegacyData() {
        return material.getLegacyData();
    }
    
    public String getLegacyName() {
        return material.getLegacyName();
    }
    
    public String getCurrentName() {
        return material.getCurrentName();
    }
    
    public String getName() {
        return material.getName();
    }
    
    public String getLegacyNominalId() {
        return material.getLegacyNominalId();
    }
    
    public String getCurrentNominalId() {
        return material.getCurrentNominalId();
    }
    
    public String getNominalId() {
        return material.getNominalId();
    }
    
    public org.bukkit.Material getBukkitMaterial() {
        return material.getMaterial();
    }
    
}
