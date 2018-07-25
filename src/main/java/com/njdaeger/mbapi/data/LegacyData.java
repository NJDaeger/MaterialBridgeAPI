package com.njdaeger.mbapi.data;

import java.util.function.Supplier;

/**
 * Legacy data of the material.
 * <p>This legacy data is no longer supported by Mojang- This could be removed in a later release.
 */
public final class LegacyData {
    
    private final int id;
    private short durability;
    
    /**
     * Creates legacy data for the given material
     * @param id The legacy id
     * @param durability The legacy durability
     */
    public LegacyData(int id, int durability) {
        this.id = id;
        this.durability = Short.parseShort(Integer.toString(durability));
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
        return durability;
    }
    
    /**
     * Calculates the durability based on the current states of the given material.
     * @param supplier The new durability.
     */
    public Short getDurability(Supplier<Short> supplier) {
        return supplier.get();
    }
    
}
