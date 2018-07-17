package com.njdaeger.mbapi.data;

/**
 * Legacy data of the material.
 * <p>This legacy data is no longer supported by Mojang- This could be removed in a later release.
 */
public final class LegacyData {
    
    private final int id;
    private final int durability;
    
    /**
     * Creates legacy data for the given material
     * @param id The legacy id
     * @param durability The legacy durability
     */
    public LegacyData(int id, int durability) {
        this.id = id;
        this.durability = durability;
    }
    
    /**
     * The legacy material ID
     * @return The legacy Id
     */
    public int getId() {
        return id;
    }
    
    /**
     * The legacy material durability
     * @return The legacy durability
     */
    public short getDurability() {
        return Short.parseShort(Integer.toString(durability));
    }
    
}
