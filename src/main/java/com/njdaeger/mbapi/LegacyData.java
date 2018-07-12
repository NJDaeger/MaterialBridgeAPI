package com.njdaeger.mbapi;

public final class LegacyData {
    
    private final int id;
    private final int durability;
    
    public LegacyData(int id, int durability) {
        this.id = id;
        this.durability = durability;
    }
    
    public int getId() {
        return id;
    }
    
    public int getDurability() {
        return durability;
    }
    
}
