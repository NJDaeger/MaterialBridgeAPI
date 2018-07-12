package com.njdaeger.mbapi;

import com.njdaeger.mbapi.type.BlockType;
import com.njdaeger.mbapi.type.Button;
import com.njdaeger.mbapi.type.Standard;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

@SuppressWarnings({"unused", "WeakerAccess"})
public final class Material<T extends BlockType> {
    
    private static final HashMap<String, Material<?>> MATERIALS = new HashMap<>();
    private static final Collection<Material<?>> MATERIAL_PRE_MAP = new ArrayList<>();
    
    public static final Material<Standard> ACACIA_BOAT = new Material<>("BOAT_ACACIA","ACACIA_BOAT", "acacia_boat", 1, new LegacyData(447, 0));
    public static final Material<Button> ACACIA_BUTTON = new Material<>("ACACIA_BUTTON", "acacia_button");
    public static final Material ACACIA_DOOR = new Material("ACACIA_DOOR", "acacia_door", new LegacyData(196, 0));
    public static final Material ACACIA_DOOR_ITEM = new Material("ACACIA_DOOR_ITEM", "ACACIA_DOOR", "acacia_door", new LegacyData(430, 0));
    public static final Material ACACIA_FENCE = new Material("ACACIA_FENCE", "acacia_fence", new LegacyData(192, 0));
    public static final Material ACACIA_FENCE_GATE = new Material("ACACIA_FENCE_GATE", "acacia_fence_gate", new LegacyData(187, 0));
    public static final Material ACACIA_STAIRS = new Material("ACACIA_STAIRS", "acacia_stairs", new LegacyData(163, 0));
    public static final Material ACACIA_LEAVES = new Material("LEAVES_2", "ACACIA_LEAVES", "acacia_leaves", "leaves2", new LegacyData(161, 0));
    public static final Material ACACIA_LOG = new Material("LOG_2", "ACACIA_LOG", "log2", "acacia_log", new LegacyData(162, 0));
    public static final Material ACACIA_PLANKS = new Material("WOOD", "ACACIA_PLANKS", "acacia_planks", "planks", new LegacyData(5, 4));
    public static final Material ACACIA_PRESSURE_PLATE = new Material("ACACIA_PRESSURE_PLATE", "acacia_pressure_plate");
    public static final Material ACACIA_SAPLING = new Material("SAPLING", "ACACIA_SAPLING", "sapling", "acacia_sapling", new LegacyData(6, 4));
    public static final Material ACACIA_SLAB = new Material("WOOD_STEP", "ACACIA_SLAB", "wooden_slab", "acacia_slab", new LegacyData(126, 4));
    public static final Material ACACIA_TRAPDOOR = new Material("ACACIA_TRAPDOOR", "acacia_trapdoor");
    public static final Material ACACIA_BARK = new Material("LOG_2", "ACACIA_WOOD", "log_2", "acacia_wood", new LegacyData(162, 12));
    public static final Material ACTIVATOR_RAIL = new Material("ACTIVATOR_RAIL", "activator_rail", new LegacyData(157, 0));
    public static final Material ALLIUM = new Material("RED_ROSE", "ALLIUM", "red_flower", "allium", new LegacyData(38, 2));
    public static final Material ANDESITE = new Material("STONE", "ANDESITE", "stone", "andesite", new LegacyData(1, 5));
    public static final Material ANVIL = new Material("ANVIL", "ANVIL", "anvil", new LegacyData(145, 0));
    public static final Material APPLE = new Material("APPLE", "apple", new LegacyData(260, 0));
    public static final Material ARMOR_STAND = new Material("ARMOR_STAND", "armor_stand", new LegacyData(460, 0));
    public static final Material ARROW = new Material("ARROW", "arrow", new LegacyData(262, 0));
    public static final Material AZURE_BLUET = new Material("RED_ROSE", "AZURE_BLUET", "red_flower", "azure_bluet", new LegacyData(38, 3));
    public static final Material ATTACHED_PUMPKIN_STEM = new Material("PUMPKIN_STEM", "ATTACHED_PUMPKIN_STEM", "pumpkin_stem", new LegacyData(104, 0));
    public static final Material ATTACHED_MELON_STEM = new Material("MELON_STEM", "ATTACHED_MELON_STEM", "melon_stem", new LegacyData(105, 0));
    
    
    
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
    private final int maxStack;
    private final LegacyData legacyData;
    
    private Material(String legacyId, String currentId, String legacyNominalId, String currentNominalId, int maxStack, LegacyData legacyData) {
        this.ordinal = MATERIAL_PRE_MAP.size();
        MATERIAL_PRE_MAP.add(this);
        this.legacy = legacyId;
        this.current = currentId;
        this.maxStack = maxStack;
        this.legacyData = legacyData;
        this.legacyNominalId = legacyNominalId;
        this.currentNominalId = currentNominalId;
    }
    
    private Material(String legacyId, String currentId, String legacyNominalId, String currentNominalId, LegacyData legacyData) {
        this(legacyId, currentId, legacyNominalId, currentNominalId, 64, legacyData);
    }
    
    private Material(String legacyId, String currentId, String nominalId, int maxStack, LegacyData legacyData) {
        this(legacyId, currentId, nominalId, nominalId, maxStack, legacyData);
    }
    
    private Material(String legacyId, String currentId, String nominalId, LegacyData legacyData) {
        this(legacyId, currentId, nominalId, 64, legacyData);
    }
    
    private Material(String id, String nominalId, int maxStack, LegacyData legacyData) {
        this(id, id, nominalId, maxStack, legacyData);
    }
    
    private Material(String id, String nominalId, LegacyData legacyData) {
        this(id, nominalId, 64, legacyData);
    }
    
    private Material(String id, String nominalId, int maxStack) {
        this(null, id, null, nominalId, maxStack, null);
    }
    
    private Material(String id, String nominalId) {
        this(id, nominalId, 64);
    }
    
    /**
     * Whether this material has legacy data.
     * @return True if this material has legacy data. (Blocks newer than 1.12 will always return false)
     */
    public final boolean hasLegacyData() {
        return legacyData != null;
    }
    
    /**
     * Gets the materials legacy data if it has any.
     * @return The materials legacy data. Null if its newer than 1.12
     */
    public final LegacyData getLegacyData() {
        return legacyData;
    }
    
    /**
     * The max stack size of this particular material
     * @return The material max stack size.
     */
    public final int getMaxStackSize() {
        return maxStack;
    }
    
    /**
     * Gets the legacy name of the Material constant. (Pre-technical, 1.12-)
     * @return The legacy name of the Material constant from Pre-technical updates.
     *
     * @apiNote <b>This will return null if this Material is newer than 1.12 UNLESS there is an API change
     *
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
    
    /**
     * Gets the current Nominal ID used by vanilla Minecraft.
     * @return The current (1.13+) Nominal ID
     */
    public final String getCurrentNominalId() {
        return currentNominalId;
    }
    
    /**
     * Gets the legacy Nominal ID used by vanilla Minecraft.
     * @return The legacy (1.12-) Nominal ID
     *
     * @apiNote <b>This will return null if this Material is newer than 1.12 UNLESS there is an internal name change.
     */
    public final String getLegacyNominalId() {
        return legacyNominalId;
    }
    
    /**
     * Gets the Nominal ID according to the current version
     * @return The proper Nominal ID according to the current version. (PRETECHNICAL = legacy, TECHNICAL = current)
     */
    public final String getNominalId() {
        return MaterialBridge.getVersion() == Version.PRETECHNICAL ? legacyNominalId : currentNominalId;
    }
    
    public final BaseBlock<T> getBlock() {
        return new BaseBlock<>(this);
    }
    
    /**
     * Gets the Bukkit {@link org.bukkit.Material} corresponding to the version.
     * @return The material to be used
     */
    public final org.bukkit.Material getMaterial() {
        if (MaterialBridge.getVersion() == Version.PRETECHNICAL) {
            if (!hasLegacyData()) return null;
            else return org.bukkit.Material.valueOf(legacy);
        }
        else return org.bukkit.Material.valueOf(current);
    }
    
    /**
     * Returns the name of this materials constant.
     * @return The name of this materials constant.
     */
    public final String name() {
        return constantName;
    }
    
    /**
     * The constant ordinal
     * @return The constant ordinal
     */
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
