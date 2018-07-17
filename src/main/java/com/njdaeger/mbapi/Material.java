package com.njdaeger.mbapi;

import com.njdaeger.mbapi.data.LegacyData;
import com.njdaeger.mbapi.data.MaterialType;
import com.njdaeger.mbapi.type.Block;
import com.njdaeger.mbapi.type.StackedBlock;
import com.njdaeger.mbapi.type.specific.Directional;
import com.njdaeger.mbapi.type.specific.Fence;
import com.njdaeger.mbapi.type.specific.Gate;
import com.njdaeger.mbapi.type.specific.Leaves;
import com.njdaeger.mbapi.type.specific.Pillar;
import com.njdaeger.mbapi.type.specific.Stairs;
import com.njdaeger.mbapi.type.specific.Switch;
import com.njdaeger.mbapi.type.Item;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

@SuppressWarnings({"unused", "WeakerAccess", "unchecked"})
public final class Material<T extends MaterialType> {
    
    private static final HashMap<String, Material<?>> MATERIALS = new HashMap<>();
    private static final Collection<Material<?>> MATERIAL_PRE_MAP = new ArrayList<>();
    
    public static final Material<Block> AIR = new Material<>("AIR", "air", new LegacyData(0, 0));
    public static final Material<Item> ACACIA_BOAT = new Material<>(Item.class, "BOAT_ACACIA","ACACIA_BOAT", "acacia_boat", 1, new LegacyData(447, 0));
    public static final Material<Switch> ACACIA_BUTTON = new Material<>(Switch.class, "ACACIA_BUTTON", "acacia_button");
    public static final Material<Block> ACACIA_DOOR = new Material<>("ACACIA_DOOR", "acacia_door", new LegacyData(196, 0));                                               //TODO
    public static final Material<Item> ACACIA_DOOR_ITEM = new Material<>("ACACIA_DOOR_ITEM", "ACACIA_DOOR", "acacia_door", new LegacyData(430, 0));
    public static final Material<Fence> ACACIA_FENCE = new Material<>("ACACIA_FENCE", "acacia_fence", new LegacyData(192, 0));
    public static final Material<Gate> ACACIA_FENCE_GATE = new Material<>(Gate.class, "ACACIA_FENCE_GATE", "acacia_fence_gate", new LegacyData(187, 0));
    public static final Material<Stairs> ACACIA_STAIRS = new Material<>(Stairs.class, "ACACIA_STAIRS", "acacia_stairs", new LegacyData(163, 0));
    public static final Material<Leaves> ACACIA_LEAVES = new Material<>(Leaves.class, "LEAVES_2", "ACACIA_LEAVES", "acacia_leaves", "leaves2", new LegacyData(161, 0));
    public static final Material<Pillar> ACACIA_LOG = new Material<>(Pillar.class, "LOG_2", "ACACIA_LOG", "log2", "acacia_log", new LegacyData(162, 0));
    public static final Material<StackedBlock> ACACIA_PLANKS = new Material<>(StackedBlock.class, "WOOD", "ACACIA_PLANKS", "acacia_planks", "planks", new LegacyData(5, 4));
    public static final Material<Block> ACACIA_PRESSURE_PLATE = new Material<>( "ACACIA_PRESSURE_PLATE", "acacia_pressure_plate");                            //TODO
    public static final Material<Block> ACACIA_SAPLING = new Material<>("SAPLING", "ACACIA_SAPLING", "sapling", "acacia_sapling", new LegacyData(6, 4));     //TODO
    public static final Material<Block> ACACIA_SLAB = new Material<>("WOOD_STEP", "ACACIA_SLAB", "wooden_slab", "acacia_slab", new LegacyData(126, 4));      //TODO
    public static final Material<Block> ACACIA_TRAPDOOR = new Material<>("ACACIA_TRAPDOOR", "acacia_trapdoor");                                              //TODO
    public static final Material<Pillar> ACACIA_BARK = new Material<>(Pillar.class, "LOG_2", "ACACIA_WOOD", "log_2", "acacia_wood", new LegacyData(162, 12));
    public static final Material<Block> ACTIVATOR_RAIL = new Material<>(Block.class, "ACTIVATOR_RAIL", "activator_rail", new LegacyData(157, 0));                         //TODO
    public static final Material<StackedBlock> ALLIUM = new Material<>(StackedBlock.class, "RED_ROSE", "ALLIUM", "red_flower", "allium", new LegacyData(38, 2));
    public static final Material<StackedBlock> ANDESITE = new Material<>(StackedBlock.class, "STONE", "ANDESITE", "stone", "andesite", new LegacyData(1, 5));
    public static final Material<Directional> ANVIL = new Material<>(Directional.class, "ANVIL", "ANVIL", "anvil", new LegacyData(145, 0));
    public static final Material<Item> APPLE = new Material<>(Item.class, "APPLE", "apple", new LegacyData(260, 0));
    public static final Material<Item> ARMOR_STAND = new Material<>(Item.class, "ARMOR_STAND", "armor_stand", 16, new LegacyData(460, 0)); //FIXME maxstack 16
    public static final Material<Item> ARROW = new Material<>(Item.class, "ARROW", "arrow", new LegacyData(262, 0));
    public static final Material<StackedBlock> AZURE_BLUET = new Material<>(StackedBlock.class, "RED_ROSE", "AZURE_BLUET", "red_flower", "azure_bluet", new LegacyData(38, 3));
    public static final Material<Block> ATTACHED_PUMPKIN_STEM = new Material<>(Block.class, "PUMPKIN_STEM", "ATTACHED_PUMPKIN_STEM", "pumpkin_stem", new LegacyData(104, 0));
    public static final Material<Block> ATTACHED_MELON_STEM = new Material<>(Block.class, "MELON_STEM", "ATTACHED_MELON_STEM", "melon_stem", new LegacyData(105, 0));
    
    
    public static final Material<Item> BAKED_POTATO = new Material(Item.class, "BAKED_POTATO", "baked_potato", new LegacyData(393, 0));
    public static final Material<StackedBlock> BARRIER = new Material(StackedBlock.class, "BARRIER", "barrier", new LegacyData(166, 0));
    public static final Material BAT_SPAWN_EGG = new Material();
    public static final Material BEACON = new Material();
    public static final Material BEDROCK = new Material();
    public static final Material BEEF = new Material();
    public static final Material BEETROOT = new Material();//item
    public static final Material BEETROOTS = new Material();//block
    public static final Material BEETROOT_SEEDS = new Material();
    public static final Material BEETROOT_SOUP = new Material(); //FIXME maxstack 1
    public static final Material BIRCH_BOAT = new Material(); //FIXME maxstack 1
    public static final Material BIRCH_BUTTON = new Material();
    public static final Material BIRCH_DOOR = new Material();
    public static final Material BIRCH_FENCE = new Material();
    public static final Material BIRCH_FENCE_GATE = new Material();
    public static final Material BIRCH_LEAVES = new Material();
    public static final Material BIRCH_LOG = new Material();
    public static final Material BIRCH_PLANKS = new Material();
    public static final Material BIRCH_PRESSURE_PLATE = new Material();
    public static final Material BIRCH_SAPLING = new Material();
    public static final Material BIRCH_SLAB = new Material();
    public static final Material BIRCH_STAIRS = new Material();
    public static final Material BIRCH_TRAPDOOR = new Material();
    public static final Material BIRCH_BARK = new Material();
    public static final Material BLACK_BANNER = new Material(); //FIXME maxstack 16
    public static final Material BLACK_BED = new Material(); //FIXME maxstack 1
    public static final Material BLACK_CARPET = new Material();
    public static final Material BLACK_CONCRETE = new Material();
    public static final Material BLACK_CONCRETE_POWDER = new Material();
    public static final Material BLACK_GLAZED_TERRACOTTA = new Material();
    public static final Material BLACK_SHULKER_BOX = new Material(); //FIXME maxstack 1
    public static final Material BLACK_STAINED_GLASS = new Material();
    public static final Material BLACK_STAINED_GLASS_PANE = new Material();
    public static final Material BLACK_TERRACOTTA = new Material();
    public static final Material BLACK_WALL_BANNER = new Material(); //might be block only
    public static final Material BLACK_WOOL = new Material();
    public static final Material BLAZE_POWDER = new Material(); //item
    public static final Material BLAZE_ROD = new Material(); //item
    public static final Material BLAZE_SPAWN_EGG = new Material();
    public static final Material BLUE_BANNER = new Material(); //FIXME maxstack 16
    public static final Material BLUE_BED = new Material(); //FIXME maxstack 1
    public static final Material BLUE_CARPET = new Material();
    public static final Material BLUE_CONCRETE = new Material();
    public static final Material BLUE_CONCRETE_POWDER = new Material();
    public static final Material BLUE_GLAZED_TERRACORRA = new Material();
    public static final Material BLUE_ICE = new Material();
    public static final Material BLUE_ORCHID = new Material();
    public static final Material BLUE_SHULKER_BOX = new Material(); //FIXME maxstack 1
    public static final Material BLUE_STAINED_GLASS = new Material();
    public static final Material BLUE_STAINED_GLASS_PANE = new Material();
    public static final Material BLUE_TERRACOTTA = new Material();
    public static final Material BLUE_WALL_BANNER = new Material(); //might be block only
    public static final Material BLUE_WOOL = new Material();
    public static final Material BONE = new Material(); //Item
    public static final Material BONE_BLOCK = new Material();
    public static final Material BONE_MEAL = new Material(); //Item
    public static final Material BOOK = new Material(); //Item
    public static final Material BOOKSHELF = new Material();
    public static final Material BOW = new Material(); //FIXME maxstack 1
    public static final Material BOWL = new Material();
    public static final Material BRAIN_CORAL = new Material(); //Item
    public static final Material BRAIN_CORAL_BLOCK = new Material(); //Block
    public static final Material BRAIN_CORAL_FAN = new Material();
    public static final Material BREAD = new Material(); //item
    public static final Material BREWING_STAND = new Material();
    public static final Material BRICK = new Material(); //item
    public static final Material BRICK_BLOCK = new Material();
    public static final Material BRICK_SLAB = new Material();
    public static final Material BRICK_STAIRS = new Material();
    public static final Material BROWN_BANNER = new Material(); //FIXME maxstack 16
    public static final Material BROWN_BED = new Material(); //FIXME maxstack 1
    public static final Material BROWN_CARPET = new Material();
    public static final Material BROWN_CONCRETE = new Material();
    public static final Material BROWN_CONCRETE_POWDER = new Material();
    public static final Material BROWN_GLAZED_TERRACOTTA = new Material();
    public static final Material BROWN_MUSHROOM = new Material();
    public static final Material BROWN_MUSHROOM_BLOCK = new Material();
    public static final Material BROWN_SHULKER_BOX = new Material(); //FIXME maxstack 1
    public static final Material BROWN_STAINED_GLASS = new Material();
    public static final Material BROWN_STAINED_GLASS_PANE = new Material();
    public static final Material BROWN_TERRACOTTA = new Material();
    public static final Material BROWN_WALL_BANNER = new Material(); //might be block only
    public static final Material BROWN_WOOL = new Material();
    public static final Material BUBBLE_COLUMN = new Material(); //block
    public static final Material BUBBLE_CORAL = new Material(); //item
    public static final Material BUBBLE_CORAL_BLOCK = new Material();
    public static final Material BUBBLE_CORAL_FAN = new Material();
    public static final Material BUCKET = new Material(); //FIXME maxstack 1
    
    
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
    private final Class<T> type;
    
    private Material(Class<T> type, String legacyId, String currentId, String legacyNominalId, String currentNominalId, int maxStack, LegacyData legacyData) {
        this.type = type;
        this.ordinal = MATERIAL_PRE_MAP.size();
        MATERIAL_PRE_MAP.add(this);
        this.legacy = legacyId;
        this.current = currentId;
        this.maxStack = maxStack;
        this.legacyData = legacyData;
        this.legacyNominalId = legacyNominalId;
        this.currentNominalId = currentNominalId;
    }
    
    private Material(String legacyId, String currentId, String legacyNominalId, String currentNominalId, int maxStack, LegacyData legacyData) {
        this((Class<T>)Block.class, legacyId, currentId, legacyNominalId, currentNominalId, maxStack, legacyData);
    }
    
    private Material(Class<T> type, String legacyId, String currentId, String legacyNominalId, String currentNominalId, LegacyData legacyData) {
        this(type, legacyId, currentId, legacyNominalId, currentNominalId, 64, legacyData);
    }
    
    private Material(String legacyId, String currentId, String legacyNominalId, String currentNominalId, LegacyData legacyData) {
        this((Class<T>)Block.class, legacyId, currentId, legacyNominalId, currentNominalId, 64, legacyData);
    }
    
    private Material(Class<T> type, String legacyId, String currentId, String nominalId, int maxStack, LegacyData legacyData) {
        this(type, legacyId, currentId, nominalId, nominalId, maxStack, legacyData);
    }
    
    private Material(String legacyId, String currentId, String nominalId, int maxStack, LegacyData legacyData) {
        this((Class<T>)Block.class, legacyId, currentId, nominalId, nominalId, maxStack, legacyData);
    }
    
    private Material(Class<T> type, String legacyId, String currentId, String nominalId, LegacyData legacyData) {
        this(type, legacyId, currentId, nominalId, 64, legacyData);
    }
    
    private Material(String legacyId, String currentId, String nominalId, LegacyData legacyData) {
        this((Class<T>)Block.class, legacyId, currentId, nominalId, 64, legacyData);
    }
    
    private Material(Class<T> type, String id, String nominalId, int maxStack, LegacyData legacyData) {
        this(type, id, id, nominalId, maxStack, legacyData);
    }
    
    private Material(String id, String nominalId, int maxStack, LegacyData legacyData) {
        this((Class<T>)Block.class, id, id, nominalId, maxStack, legacyData);
    }
    
    
    private Material(Class<T> type, String id, String nominalid, LegacyData legacyData) {
        this(type, id, nominalid, 64, legacyData);
    }
    
    private Material(String id, String nominalId, LegacyData legacyData) {
        this((Class<T>)Block.class, id, nominalId, legacyData);
    }
    
    private Material(Class<T> type, String id, String nominalId, int maxStack) {
        this(type, null, id, null, nominalId, maxStack, null);
    }
    
    private Material(String id, String nominalId, int maxStack) {
        this((Class<T>)Block.class, id, nominalId, maxStack);
    }
    
    private Material(Class<T> type, String id, String nominalId) {
        this(type, id, nominalId, 64);
    }
    
    private Material(String id, String nominalId) {
        this((Class<T>)Block.class, id, nominalId);
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
    
    /**
     * Get the class type of this material.
     * @return The material class type.
     */
    public Class<T> getType() {
        return type;
    }
    
    /**
     * Get the MaterialType of this material.
     * @return The material type of this material.
     */
    public final T get() {
        try {
            return type.getConstructor(Material.class).newInstance(this);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        throw new TypeNotCreatedException(constantName);
    }
    
    /**
     * Gets the Bukkit {@link org.bukkit.Material} corresponding to the version.
     * @return The material to be used
     */
    public final org.bukkit.Material getBukkitMaterial() {
        if (MaterialBridge.isPretechnical()) {
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
     * Gets the MPAPI instance of the given Bukkit Material.
     * @param bukkitMaterial The Bukkit Material to be converted.
     * @return The corresponding bukkit material.
     */
    public static Material<?> of(org.bukkit.Material bukkitMaterial) {
        for (Material<?> material : values()) {
            if (material.getName().equals(bukkitMaterial.name())) return material;
        }
        return null;
    }
    
    /**
     * Gets a material via its constant name in this class.
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
    public static <T extends MaterialType> Material<T> valueOf(Class<T> blockType, String name) {
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
