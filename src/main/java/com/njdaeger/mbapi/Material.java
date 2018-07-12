package com.njdaeger.mbapi;

import com.njdaeger.mbapi.type.Air;
import com.njdaeger.mbapi.type.BlockType;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public final class Material<T extends BlockType> {
    
    private static final HashMap<String, Material<?>> MATERIALS = new HashMap<>();
    private static final Collection<Material<?>> MATERIAL_PRE_MAP = new ArrayList<>();
    
    public static final Material<Air> ACACIA_BOAT = new Material<>("BOAT_ACACIA","ACACIA_BOAT", "acacia_boat");
    public static final Material ACACIA_BUTTON = new Material("WOOD_BUTTON", "ACACIA_BUTTON", "wooden_button", "acacia_button");
    
    static {
        for (Field f : Material.class.getFields()) {
            if (!f.getType().equals(Material.class)) continue;
            for (Material<?> mat : MATERIAL_PRE_MAP) {
                try {
                    if (f.get(null).equals(mat)) {
                        mat.constantName = f.getName();
                        MATERIALS.put(f.getName(), mat);
                    }
                }
                catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private String constantName;
    private final String legacy;
    private final String current;
    private final String currentNominalId;
    private final String legacyNominalId;
    private final int ordinal;
    
    private Material(String legacy, String current, String nominalId) {
        this(legacy, current, nominalId, nominalId);
    }
    
    private Material(String legacy, String current, String currentNominalId, String legacyNominal) {
        this.ordinal = MATERIAL_PRE_MAP.size();
        MATERIAL_PRE_MAP.add(this);
        this.currentNominalId = currentNominalId;
        this.legacyNominalId = legacyNominal;
        this.current = current;
        this.legacy = legacy;
    }
    
    /**
     * Gets the legacy name of the Material constant. (Pre-technical, 1.12-)
     * @return The legacy name of the Material constant from Pre-technical updates.
     */
    public final String getLegacyName() {
        return legacy;
    }
    
    /**
     * Gets the name of the Material constant as described in the Technical update (1.13+)
     * @return The name of the Material constant as described in the Technical update.
     */
    public final String getCurrentName() {
        return current;
    }
    
    /**
     * Gets the name of the constant according to the current running version
     * @return The name of the item.
     */
    public final String getName() {
        return MaterialBridge.getVersion() == Version.PRETECHNICAL ? legacy : current;
    }
    
    public final String getCurrentNominalId() {
        return currentNominalId;
    }
    
    public final String getLegacyNominalId() {
        return legacyNominalId;
    }
    
    public final String getNominalId() {
        return MaterialBridge.getVersion() == Version.PRETECHNICAL ? legacyNominalId : currentNominalId;
    }
    
    public final BaseBlock<T> getType() {
        return new BaseBlock<>(this);
    }
    
    public final org.bukkit.Material getMaterial() {
        return MaterialBridge.getVersion() == Version.PRETECHNICAL ? org.bukkit.Material.valueOf(legacy) : org.bukkit.Material.valueOf(current);
    }
    
    public final String name() {
        return constantName;
    }

    public final int ordinal() {
        return ordinal;
    }

    @Override
    public String toString() {
        return constantName;
    }
    
    /**
     * Gets a material via its enum name.
     * @param name The name of the material constant
     * @return The material if it exists.
     * @throws NullPointerException if the name specified is null
     * @throws IllegalArgumentException if the name specified is not a present constant
     */
    public static Material<?> valueOf(String name) {
        if (name == null) throw new NullPointerException("Name is null");
        for (Material<?> material : MATERIALS.values()) {
            if (material.name().equals(name)) return material;
        }
        throw new IllegalArgumentException("No enum constant " + Material.class.getCanonicalName() + "." + name);
    }
    /**
     * Gets a material via its enum name.
     * @param blockType The blocktype class of the material.
     * @param name The name of the material constant
     * @return The material if it exists.
     * @throws NullPointerException if the name specified is null
     * @throws IllegalArgumentException if the name specified is not a present constant
     */
    @SuppressWarnings("unchecked")
    public static <T extends BlockType> Material<T> valueOf(Class<T> blockType, String name) {
        return (Material<T>)valueOf(name);
    }
    
    /**
     * Gets an array of all the Materials
     * @return Array of all the materials.
     */
    public static Material<?>[] values() {
        return Collections.unmodifiableCollection(MATERIALS.values()).toArray(new Material[0]);
    }
    
}
