package com.njdaeger.mbapi;

import com.njdaeger.mbapi.data.LegacyData;
import com.njdaeger.mbapi.data.MaterialType;
import com.njdaeger.mbapi.exceptions.ConstantNotFoundException;
import com.njdaeger.mbapi.exceptions.IncompatibleVersionException;
import com.njdaeger.mbapi.exceptions.TypeNotCreatedException;
import com.njdaeger.mbapi.type.Block;
import com.njdaeger.mbapi.type.Item;
import com.njdaeger.mbapi.type.StackedBlock;
import com.njdaeger.mbapi.type.specific.Ageable;
import com.njdaeger.mbapi.type.specific.AgeableBlock;
import com.njdaeger.mbapi.type.specific.Banner;
import com.njdaeger.mbapi.type.specific.Bed;
import com.njdaeger.mbapi.type.specific.BubbleColumn;
import com.njdaeger.mbapi.type.specific.Cake;
import com.njdaeger.mbapi.type.specific.Cauldron;
import com.njdaeger.mbapi.type.specific.Chest;
import com.njdaeger.mbapi.type.specific.Cocoa;
import com.njdaeger.mbapi.type.specific.CommandBlock;
import com.njdaeger.mbapi.type.specific.Comparator;
import com.njdaeger.mbapi.type.specific.DaylightDetector;
import com.njdaeger.mbapi.type.specific.Directional;
import com.njdaeger.mbapi.type.specific.Divider;
import com.njdaeger.mbapi.type.specific.Door;
import com.njdaeger.mbapi.type.specific.EndPortalFrame;
import com.njdaeger.mbapi.type.specific.EndRod;
import com.njdaeger.mbapi.type.specific.EnderChest;
import com.njdaeger.mbapi.type.specific.Farmland;
import com.njdaeger.mbapi.type.specific.Fire;
import com.njdaeger.mbapi.type.specific.Furnace;
import com.njdaeger.mbapi.type.specific.Gate;
import com.njdaeger.mbapi.type.specific.Leaves;
import com.njdaeger.mbapi.type.specific.MultiDirectional;
import com.njdaeger.mbapi.type.specific.Pillar;
import com.njdaeger.mbapi.type.specific.PressurePlate;
import com.njdaeger.mbapi.type.specific.RedstoneRail;
import com.njdaeger.mbapi.type.specific.Rotatable;
import com.njdaeger.mbapi.type.specific.Sapling;
import com.njdaeger.mbapi.type.specific.Slab;
import com.njdaeger.mbapi.type.specific.Stairs;
import com.njdaeger.mbapi.type.specific.Switch;
import com.njdaeger.mbapi.type.specific.Trapdoor;
import com.njdaeger.mbapi.type.specific.Triggered;
import com.njdaeger.mbapi.type.specific.WallFan;
import com.njdaeger.mbapi.type.specific.Waterlogged;
import com.njdaeger.mbapi.version.Version;
import com.njdaeger.mbapi.version.v113;

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
    
    //A's are done.
    public static final Material<Block> AIR = new Material<>("AIR", "air", new LegacyData(0, 0));
    public static final Material<Item> ACACIA_BOAT = new Material<>(Item.class, "BOAT_ACACIA","ACACIA_BOAT", "acacia_boat", 1, new LegacyData(447, 0));
    @v113 public static final Material<Switch> ACACIA_BUTTON = new Material<>(Switch.class, "ACACIA_BUTTON", "acacia_button");
    public static final Material<Door> ACACIA_DOOR = new Material<>(Door.class, "ACACIA_DOOR", "acacia_door", new LegacyData(196, 0));
    public static final Material<Divider> ACACIA_FENCE = new Material<>("ACACIA_FENCE", "acacia_fence", new LegacyData(192, 0));
    public static final Material<Gate> ACACIA_FENCE_GATE = new Material<>(Gate.class, "ACACIA_FENCE_GATE", "acacia_fence_gate", new LegacyData(187, 0));
    public static final Material<Stairs> ACACIA_STAIRS = new Material<>(Stairs.class, "ACACIA_STAIRS", "acacia_stairs", new LegacyData(163, 0));
    public static final Material<Leaves> ACACIA_LEAVES = new Material<>(Leaves.class, "LEAVES_2", "ACACIA_LEAVES", "acacia_leaves", "leaves2", new LegacyData(161, 0));
    public static final Material<Pillar> ACACIA_LOG = new Material<>(Pillar.class, "LOG_2", "ACACIA_LOG", "log2", "acacia_log", new LegacyData(162, 0));
    public static final Material<StackedBlock> ACACIA_PLANKS = new Material<>(StackedBlock.class, "WOOD", "ACACIA_PLANKS", "planks", "acacia_planks", new LegacyData(5, 4));
    @v113 public static final Material<PressurePlate> ACACIA_PRESSURE_PLATE = new Material<>(PressurePlate.class, "ACACIA_PRESSURE_PLATE", "acacia_pressure_plate");
    public static final Material<Sapling> ACACIA_SAPLING = new Material<>(Sapling.class, "SAPLING", "ACACIA_SAPLING", "sapling", "acacia_sapling", new LegacyData(6, 4));
    public static final Material<Slab> ACACIA_SLAB = new Material<>(Slab.class, "WOOD_STEP", "ACACIA_SLAB", "wooden_slab", "acacia_slab", new LegacyData(126, 4));
    @v113 public static final Material<Trapdoor> ACACIA_TRAPDOOR = new Material<>(Trapdoor.class, "ACACIA_TRAPDOOR", "acacia_trapdoor");
    public static final Material<Pillar> ACACIA_BARK = new Material<>(Pillar.class, "LOG_2", "ACACIA_WOOD", "log_2", "acacia_wood", new LegacyData(162, 12));
    public static final Material<RedstoneRail> ACTIVATOR_RAIL = new Material<>(RedstoneRail.class, "ACTIVATOR_RAIL", "activator_rail", new LegacyData(157, 0));
    public static final Material<StackedBlock> ALLIUM = new Material<>(StackedBlock.class, "RED_ROSE", "ALLIUM", "red_flower", "allium", new LegacyData(38, 2));
    public static final Material<StackedBlock> ANDESITE = new Material<>(StackedBlock.class, "STONE", "ANDESITE", "stone", "andesite", new LegacyData(1, 5));
    public static final Material<Directional> ANVIL = new Material<>(Directional.class, "ANVIL", "ANVIL", "anvil", new LegacyData(145, 0));
    public static final Material<Item> APPLE = new Material<>(Item.class, "APPLE", "apple", new LegacyData(260, 0));
    public static final Material<Item> ARMOR_STAND = new Material<>(Item.class, "ARMOR_STAND", "armor_stand", 16, new LegacyData(460, 0));
    public static final Material<Item> ARROW = new Material<>(Item.class, "ARROW", "arrow", new LegacyData(262, 0));
    public static final Material<StackedBlock> AZURE_BLUET = new Material<>(StackedBlock.class, "RED_ROSE", "AZURE_BLUET", "red_flower", "azure_bluet", new LegacyData(38, 3));
    public static final Material<Directional> ATTACHED_PUMPKIN_STEM = new Material<>(Directional.class, "PUMPKIN_STEM", "ATTACHED_PUMPKIN_STEM", "pumpkin_stem", new LegacyData(104, 0));
    public static final Material<Directional> ATTACHED_MELON_STEM = new Material<>(Directional.class, "MELON_STEM", "ATTACHED_MELON_STEM", "melon_stem", new LegacyData(105, 0));
    
    
    public static final Material<Item> BAKED_POTATO = new Material<>(Item.class, "BAKED_POTATO", "baked_potato", new LegacyData(393, 0));
    public static final Material<StackedBlock> BARRIER = new Material<>(StackedBlock.class, "BARRIER", "barrier", new LegacyData(166, 0));
    public static final Material<Item> BAT_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "BAT_SPAWN_EGG", "spawn_egg", "bat_spawn_egg", new LegacyData(383, 65));
    public static final Material<StackedBlock> BEACON = new Material<>(StackedBlock.class, "BEACON", "beacon", new LegacyData(138, 0));
    public static final Material<StackedBlock> BEDROCK = new Material<>(StackedBlock.class, "BEDROCK", "bedrock", new LegacyData(7, 0));
    public static final Material<Item> BEEF = new Material<>(Item.class, "RAW_BEEF", "BEEF", "beef", new LegacyData(363, 0));
    public static final Material<Item> BEETROOT = new Material<>(Item.class, "BEETROOT", "beetroot", new LegacyData(434, 0));//item
    public static final Material<Block> BEETROOT_BLOCK = new Material<>("BEETROOT_BLOCK", "BEETROOTS", "beetroots", new LegacyData(207, 0));///TODO this is ageable
    public static final Material<Item> BEETROOT_SEEDS = new Material<>(Item.class, "BEETROOT_SEEDS", "beetroot_seeds", new LegacyData(435, 0));
    public static final Material<Item> BEETROOT_SOUP = new Material<>(Item.class, "BEETROOT_SOUP", "beetroot_soup", 1, new LegacyData(436, 0));
    public static final Material<Item> BIRCH_BOAT = new Material<>(Item.class, "BOAT_BIRCH", "BIRCH_BOAT", "birch_boat", 1, new LegacyData(445, 0));
    @v113 public static final Material<Switch> BIRCH_BUTTON = new Material<>(Switch.class, "BIRCH_BUTTON", "birch_button");
    public static final Material<Door> BIRCH_DOOR = new Material<>(Door.class, "BIRCH_DOOR", "birch_door", new LegacyData(194, 0));
    public static final Material<Divider> BIRCH_FENCE = new Material<>(Divider.class, "BIRCH_FENCE", "birch_fence", new LegacyData(189, 0));
    public static final Material<Gate> BIRCH_FENCE_GATE = new Material<>(Gate.class, "BIRCH_FENCE_GATE", "birch_fence_gate", new LegacyData(184, 0));
    public static final Material<Leaves> BIRCH_LEAVES = new Material<>(Leaves.class, "LEAVES", "BIRCH_LEAVES", "leaves", "birch_leaves", new LegacyData(18, 2));
    public static final Material<Pillar> BIRCH_LOG = new Material<>(Pillar.class, "LOG", "BIRCH_LOG", "log", "birch_log", new LegacyData(17, 2));
    public static final Material<StackedBlock> BIRCH_PLANKS = new Material<>(StackedBlock.class, "WOOD", "BIRCH_PLANKS", "planks", "birch_planks", new LegacyData(5, 2));
    @v113 public static final Material<PressurePlate> BIRCH_PRESSURE_PLATE = new Material<>(PressurePlate.class, "BIRCH_PRESSURE_PLATE", "birch_pressure_plate");
    public static final Material<Sapling> BIRCH_SAPLING = new Material<>(Sapling.class, "SAPLING", "BIRCH_SAPLING", "sapling", "birch_sapling", new LegacyData(6, 2));
    public static final Material<Slab> BIRCH_SLAB = new Material<>(Slab.class, "WOOD_STEP", "BIRCH_SLAB", "wooden_slab", "birch_slab", new LegacyData(126, 2));
    public static final Material<Stairs> BIRCH_STAIRS = new Material<>(Stairs.class, "BIRCH_WOOD_STAIRS", "BIRCH_STAIRS", "birch_stairs", new LegacyData(135, 0));
    @v113 public static final Material<Trapdoor> BIRCH_TRAPDOOR = new Material<>(Trapdoor.class, "BIRCH_TRAPDOOR", "birch_trapdoor");
    public static final Material<Pillar> BIRCH_BARK = new Material<>(Pillar.class, "LOG", "BIRCH_WOOD", "log", "birch_wood", new LegacyData(5, 14));
    public static final Material<Banner> BLACK_BANNER = new Material<>(Banner.class, "STANDING_BANNER", "BLACK_BANNER", "banner", "black_banner", 16, new LegacyData(425, 0));
    public static final Material<Bed> BLACK_BED = new Material<>(Bed.class, "BED_BLOCK", "BLACK_BED", "bed", "black_bed", 1, new LegacyData(355, 15));
    public static final Material<StackedBlock> BLACK_CARPET = new Material<>(StackedBlock.class, "CARPET", "BLACK_CARPET", "carpet", "black_carpet", new LegacyData(171, 15));
    public static final Material<StackedBlock> BLACK_CONCRETE = new Material<>(StackedBlock.class, "CONCRETE", "BLACK_CONCRETE", "concrete", "black_concrete", new LegacyData(251, 15));
    public static final Material<StackedBlock> BLACK_CONCRETE_POWDER = new Material<>(StackedBlock.class, "CONCRETE_POWDER", "BLACK_CONCRETE_POWDER", "concrete_powder", "black_concrete_powder", new LegacyData(252, 15));
    public static final Material<Directional> BLACK_GLAZED_TERRACOTTA = new Material<>(Directional.class, "BLACK_GLAZED_TERRACOTTA", "black_glazed_terracotta", new LegacyData(250, 0));
    public static final Material<Directional> BLACK_SHULKER_BOX = new Material<>(Directional.class, "BLACK_SHULKER_BOX", "black_shulker_box", 1, new LegacyData(234, 0));
    public static final Material<StackedBlock> BLACK_STAINED_GLASS = new Material<>(StackedBlock.class, "STAINED_GLASS", "BLACK_STAINED_GLASS", "stained_glass", "black_stained_glass", new LegacyData(95, 15));
    public static final Material<Divider> BLACK_STAINED_GLASS_PANE = new Material<>(Divider.class, "STAINED_GLASS_PANE", "BLACK_STAINED_GLASS_PANE", "stained_glass_pane", "black_stained_glass_pane", new LegacyData(160, 15));
    public static final Material<StackedBlock> BLACK_TERRACOTTA = new Material<>(StackedBlock.class, "STAINED_CLAY", "BLACK_TERRACOTTA", "stained_hardended_clay", "black_terracotta", new LegacyData(159, 15));
    public static final Material<Banner> BLACK_WALL_BANNER = new Material<>(Banner.class, "WALL_BANNER", "BLACK_WALL_BANNER", "standing_banner", "wall_banner", new LegacyData(177, 15));
    public static final Material<StackedBlock> BLACK_WOOL = new Material<>(StackedBlock.class, "WOOL", "BLACK_WOOL", "wool", "black_wool", new LegacyData(35, 15));
    public static final Material<Item> BLAZE_POWDER = new Material<>(Item.class, "BLAZE_POWDER", "blaze_powder", new LegacyData(377, 0));
    public static final Material<Item> BLAZE_ROD = new Material<>(Item.class, "BLAZE_ROD", "blaze_rod", new LegacyData(369, 0));
    public static final Material<Item> BLAZE_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "BLAZE_SPAWN_EGG", "spawn_egg", "blaze_spawn_egg", new LegacyData(383, 61));
    public static final Material<Banner> BLUE_BANNER = new Material<>(Banner.class, "STANDING_BANNER", "BLUE_BANNER", "banner", "blue_banner", 16, new LegacyData(425, 4));
    public static final Material<Bed> BLUE_BED = new Material<>(Bed.class, "BED_BLOCK", "BLUE_BED", "bed", "blue_bed", 1, new LegacyData(355, 11));
    public static final Material<StackedBlock> BLUE_CARPET = new Material<>(StackedBlock.class, "CARPET", "BLUE_CARPET", "carpet", "blue_carpet", new LegacyData(171, 11));
    public static final Material<StackedBlock> BLUE_CONCRETE = new Material<>(StackedBlock.class, "CONCRETE", "BLUE_CONCRETE", "concrete", "blue_concrete", new LegacyData(251, 11));
    public static final Material<StackedBlock> BLUE_CONCRETE_POWDER = new Material<>(StackedBlock.class, "CONCRETE_POWDER", "BLUE_CONCRETE_POWDER", "concrete_powder", "blue_concrete_powder", new LegacyData(252, 11));
    public static final Material<Directional> BLUE_GLAZED_TERRACOTTA = new Material<>(Directional.class, "BLUE_GLAZED_TERRACOTTA", "blue_glazed_terracotta", new LegacyData(246, 0));
    @v113 public static final Material<StackedBlock> BLUE_ICE = new Material<>(StackedBlock.class, "BLUE_ICE", "blue_ice");
    public static final Material<StackedBlock> BLUE_ORCHID = new Material<>(StackedBlock.class, "RED_ROSE", "BLUE_ORCHID", "red_flower", "blue_orchid", new LegacyData(38, 1));
    public static final Material<Directional> BLUE_SHULKER_BOX = new Material<>(Directional.class, "BLUE_SHULKER_BOX", "blue_shulker_box", 1, new LegacyData(230, 0));
    public static final Material<StackedBlock> BLUE_STAINED_GLASS = new Material<>(StackedBlock.class, "STAINED_GLASS", "BLUE_STAINED_GLASS", "stained_glass", "blue_stained_glass", new LegacyData(95, 11));
    public static final Material<Divider> BLUE_STAINED_GLASS_PANE = new Material<>(Divider.class, "STAINED_GLASS_PANE", "BLUE_STAINED_GLASS_PANE", "stained_glass_pane", "blue_stained_glass_pane", new LegacyData(160, 11));
    public static final Material<StackedBlock> BLUE_TERRACOTTA = new Material<>(StackedBlock.class, "STAINED_CLAY", "BLUE_TERRACOTTA", "stained_hardended_clay", "blue_terracotta", new LegacyData(159, 11));
    public static final Material<Banner> BLUE_WALL_BANNER = new Material<>(Banner.class, "WALL_BANNER", "BLUE_WALL_BANNER", "standing_banner", "wall_banner", new LegacyData(177, 11));
    public static final Material<StackedBlock> BLUE_WOOL = new Material<>(StackedBlock.class, "WOOL", "BLUE_WOOL", "wool", "blue_wool", new LegacyData(35, 11));
    public static final Material<Item> BONE = new Material<>(Item.class, "BONE", "bone", new LegacyData(352, 0));
    public static final Material<Pillar> BONE_BLOCK = new Material<>(Pillar.class, "BONE_BLOCK", "bone_block", new LegacyData(215, 0));
    public static final Material<Item> BONE_MEAL = new Material<>(Item.class, "INK_SACK", "BONE_MEAL", "dye", "bone_meal", new LegacyData(351, 15));
    public static final Material<Item> BOOK = new Material<>(Item.class, "BOOK", "book", new LegacyData(340, 0));
    public static final Material<StackedBlock> BOOKSHELF = new Material<>(StackedBlock.class, "BOOKSHELF", "bookshelf", new LegacyData(47, 0));
    public static final Material<Item> BOW = new Material<>(Item.class, "BOW", "bow", new LegacyData(261, 0));
    public static final Material<Item> BOWL = new Material<>(Item.class, "BOWL", "bowl", new LegacyData(281, 0));
    @v113 public static final Material<StackedBlock> BRAIN_CORAL = new Material<>(StackedBlock.class, "BRAIN_CORAL", "brain_coral");
    @v113 public static final Material<StackedBlock> BRAIN_CORAL_BLOCK = new Material<>(StackedBlock.class, "BRAIN_CORAL_BLOCK", "brain_coral_block");
    @v113 public static final Material<Waterlogged> BRAIN_CORAL_FAN = new Material<>(Waterlogged.class, "BRAIN_CORAL_FAN", "brain_coral_fan");
    @v113 public static final Material<WallFan> BRAIN_CORAL_WALL_FAN = new Material<>(WallFan.class, "BRAIN_CORAL_WALL_FAN", "brain_coral_wall_fan");
    public static final Material<Item> BREAD = new Material<>(Item.class, "BREAD", "bread", new LegacyData(297, 0));
    public static final Material<StackedBlock> BREWING_STAND = new Material<>(StackedBlock.class, "BREWING_STAND", "brewing_stand", new LegacyData(117, 0));//todo brewing
    public static final Material<Item> BRICK = new Material<>(Item.class, "CLAY_BRICK", "BRICK", "brick", new LegacyData(336, 0));
    public static final Material<StackedBlock> BRICK_BLOCK = new Material<>(StackedBlock.class, "BRICK", "BRICKS", "brick_block", "bricks", new LegacyData(45, 0));
    public static final Material<Slab> BRICK_SLAB = new Material<>(Slab.class, "STEP", "BRICK_SLAB", "brick_slab", "stone_slab", new LegacyData(44, 4));
    public static final Material<Stairs> BRICK_STAIRS = new Material<>(Stairs.class, "BRICK_STAIRS", "brick_stairs", new LegacyData(108, 0));
    public static final Material<Banner> BROWN_BANNER = new Material<>(Banner.class, "STANDING_BANNER", "BROWN_BANNER", "banner", "brown_banner", 16, new LegacyData(425, 3));
    public static final Material<Bed> BROWN_BED = new Material<>(Bed.class, "BED_BLOCK", "BROWN_BED", "bed", "brown_bed", 1, new LegacyData(355, 12));
    public static final Material<StackedBlock> BROWN_CARPET = new Material<>(StackedBlock.class, "CARPET", "BROWN_CARPET", "carpet", "brown_carpet", new LegacyData(171, 12));
    public static final Material<StackedBlock> BROWN_CONCRETE = new Material<>(StackedBlock.class, "CONCRETE", "BROWN_CONCRETE", "concrete", "brown_concrete", new LegacyData(251, 12));
    public static final Material<StackedBlock> BROWN_CONCRETE_POWDER = new Material<>(StackedBlock.class, "CONCRETE_POWDER", "BROWN_CONCRETE_POWDER", "concrete_powder", "brown_concrete_powder", new LegacyData(252, 12));
    public static final Material<Directional> BROWN_GLAZED_TERRACOTTA = new Material<>(Directional.class, "BROWN_GLAZED_TERRACOTTA", "brown_glazed_terracotta", new LegacyData(247, 0));
    public static final Material<StackedBlock> BROWN_MUSHROOM = new Material<>(StackedBlock.class, "BROWN_MUSHROOM", "brown_mushroom", new LegacyData(39, 0));
    public static final Material<MultiDirectional> BROWN_MUSHROOM_BLOCK = new Material<>(MultiDirectional.class, "HUGE_MUSHROOM_1", "BROWN_MUSHROOM_BLOCK", "brown_mushroom_block", new LegacyData(99, 0));
    public static final Material<Directional> BROWN_SHULKER_BOX = new Material<>(Directional.class, "BROWN_SHULKER_BOX", "brown_shulker_box", 1, new LegacyData(231, 0));
    public static final Material<StackedBlock> BROWN_STAINED_GLASS = new Material<>(StackedBlock.class, "STAINED_GLASS", "BROWN_STAINED_GLASS", "stained_glass", "brown_stained_glass", new LegacyData(95, 12));
    public static final Material<Divider> BROWN_STAINED_GLASS_PANE = new Material<>(Divider.class, "STAINED_GLASS_PANE", "BROWN_STAINED_GLASS_PANE", "stained_glass_pane", "brown_stained_glass_pane", new LegacyData(160, 12));
    public static final Material<StackedBlock> BROWN_TERRACOTTA = new Material<>(StackedBlock.class, "STAINED_CLAY", "BROWN_TERRACOTTA", "stained_hardended_clay", "brown_terracotta", new LegacyData(159, 12));
    public static final Material<Banner> BROWN_WALL_BANNER = new Material<>(Banner.class, "WALL_BANNER", "BROWN_WALL_BANNER", "standing_banner", "wall_banner", new LegacyData(177, 12));
    public static final Material<StackedBlock> BROWN_WOOL = new Material<>(StackedBlock.class, "WOOL", "BROWN_WOOL", "wool", "brown_wool", new LegacyData(35, 12));
    @v113 public static final Material<BubbleColumn> BUBBLE_COLUMN = new Material<>(BubbleColumn.class, "BUBBLE_COLUMN", "bubble_column");
    @v113 public static final Material<StackedBlock> BUBBLE_CORAL = new Material<>(StackedBlock.class, "BUBBLE_CORAL", "bubble_coral");
    @v113 public static final Material<StackedBlock> BUBBLE_CORAL_BLOCK = new Material<>(StackedBlock.class, "BUBBLE_CORAL_BLOCK", "bubble_coral_block");
    @v113 public static final Material<StackedBlock> BUBBLE_CORAL_FAN = new Material<>(StackedBlock.class, "BUBBLE_CORAL_FAN", "bubble_coral_fan");
    public static final Material<Item> BUCKET = new Material<>(Item.class, "BUCKET", "bucket", 16, new LegacyData(325, 0));
    
    /*
    Name:                       Status:     Tech|PreTech
    TODO: Cauldron              started       X | X
    TODO: Fluid                 started         |
    TODO: Ageable               started         |
    TODO: AgeableBlock          started         |
    TODO: CommandBlock          started         |
    TODO: Chest                 started         |
    TODO: Comparator            started         |
    TODO: PlayerSkull           started         |
    TODO: DaylightDetector      started         |
    TODO: EnderChest            started         |
    TODO: EndPortalFrame        started         |
    TODO: Farmland              started         |
    TODO: Fire                  started         |
    TODO: Furnace               started         |
    TODO: Snowable              started         |
    TODO: PowerTransferable                     |
    TODO: Jukebox                               |
    TODO: Ladder                                |
    TODO: TechnicalPiston                       |
    TODO: NoteBlock                             |
    TODO: Lightable                             |
    TODO: RedstoneWallTorch                     |
    TODO: Bisected                              |
    TODO: Repeater                              |
    TODO: SeaPickle                             |
    TODO: Piston                                |
    TODO: PistonHead                            |
    TODO: StructureBlock                        |
    TODO: Tripwire                              |
    TODO: TripwireHook                          |
    TODO: TurtleEgg                             |
    TODO: WallSign                              |
    TODO: WallFan               started         |
    TODO: Cocoa                 started         |
    TODO: Rotatable             started         |
    TODO: Cake                  started         |
    TODO: Triggered             started         |
    TODO: EndRod                started         |
    
     */
    
    public static final Material<Ageable> CACTUS = new Material<>(Ageable.class, "CACTUS", "cactus", new LegacyData(81, 0));
    public static final Material<Item> CACTUS_GREEN = new Material<>(Item.class, "INK_SACK", "CACTUS_GREEN", "dye", "cactus_green", new LegacyData(351, 2));
    public static final Material<Cake> CAKE = new Material<>(Cake.class, "CAKE_BLOCK", "CAKE", "cake", new LegacyData(92, 0)); //todo cake
    public static final Material<Item> CARROT = new Material<>(Item.class, "CARROT_ITEM", "CARROT", "carrot", new LegacyData(391, 0));
    public static final Material<AgeableBlock> CARROTS = new Material<>("CARROT", "CARROTS", "carrots", new LegacyData(141, 0));
    public static final Material<Item> CARROT_ON_A_STICK = new Material<>(Item.class, "CARROT_STICK", "CARROT_ON_A_STICK", "carrot_on_a_stick", 1, new LegacyData(398, 0));
    public static final Material<Directional> CARVED_PUMPKIN = new Material<>(Directional.class, "PUMPKIN", "CARVED_PUMPKIN", "pumpkin", "carved_pumpkin", new LegacyData(86, 0));
    public static final Material<Cauldron> CAULDRON = new Material<>(Cauldron.class, "CAULDRON", "cauldron", new LegacyData(118, 0));
    @v113 public static final Material<Block> CAVE_AIR = new Material<>("CAVE_AIR", "cave_air");
    public static final Material<Item> CAVE_SPIDER_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "CAVE_SPIDER_SPAWN_EGG", "spawn_egg", "cave_spider_spawn_egg", new LegacyData(383, 59));
    public static final Material<Item> CHAINMAIL_BOOTS = new Material<>(Item.class, "CHAINMAIL_BOOTS", "chainmail_boots", 1, new LegacyData(305, 0));
    public static final Material<Item> CHAINMAIL_CHESTPLATE = new Material<>(Item.class, "CHAINMAIL_CHESTPLATE", "chainmail_chestplate", 1, new LegacyData(303, 0));
    public static final Material<Item> CHAINMAIL_HELMET = new Material<>(Item.class, "CHAINMAIL_HELMET", "chainmail_helmet", 1, new LegacyData(302, 0));
    public static final Material<Item> CHAINMAIL_LEGGINGS = new Material<>(Item.class, "CHAINMAIL_LEGGINGS", "chainmail_leggings", 1, new LegacyData(304, 0));
    public static final Material<CommandBlock> CHAIN_COMMAND_BLOCK = new Material<>(CommandBlock.class, "CHAIN_COMMAND_BLOCK", "chain_command_block", new LegacyData(211, 0));
    public static final Material<Item> CHARCOAL = new Material<>(Item.class, "COAL", "CHARCOAL", "charcoal", new LegacyData(263, 1));
    public static final Material<Chest> CHEST = new Material<>(Chest.class, "CHEST", "chest", new LegacyData(54, 0));
    public static final Material<Item> CHEST_MINECART = new Material<>(Item.class, "STORAGE_MINECART", "CHEST_MINECART", "chest_minecart", 1, new LegacyData(342, 0));
    public static final Material<Item> CHICKEN = new Material<>(Item.class, "RAW_CHICKEN", "CHICKEN", "chicken", new LegacyData(365, 0));
    public static final Material<Item> CHICKEN_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "CHICKEN_SPAWN_EGG", "spawn_egg", "chicken_spawn_egg", new LegacyData(383, 93));
    public static final Material<Directional> CHIPPED_ANVIL = new Material<>(Directional.class, "ANVIL", "CHIPPED_ANVIL", "anvil", "chipped_anvil", new LegacyData(145, 1));
    public static final Material<StackedBlock> CHISELED_QUARTZ_BLOCK = new Material<>(StackedBlock.class, "QUARTZ_BLOCK", "CHISELED_QUARTZ_BLOCK", "quartz", "chiseled_quartz_block", new LegacyData(155, 1));
    public static final Material<StackedBlock> CHISELED_RED_SANDSTONE = new Material<>(StackedBlock.class, "RED_SANDSTONE", "CHISELED_RED_SANDSTONE", "red_sandstone", "chiseled_red_sandstone", new LegacyData(179, 1));
    public static final Material<StackedBlock> CHISELED_SANDSTONE = new Material<>(StackedBlock.class, "SANDSTONE", "CHISELED_SANDSTONE", "sandstone", "chiseled_sandstone", new LegacyData(24, 1));
    public static final Material<StackedBlock> CHISELED_STONE_BRICKS = new Material<>(StackedBlock.class, "SMOOTH_BRICK", "CHISELED_STONE_BRICKS", "stonebrick", "chiseled_stone_bricks", new LegacyData(98, 3));
    public static final Material<Ageable> CHORUS_FLOWER = new Material<>(Ageable.class, "CHORUS_FLOWER", "chorus_flower", new LegacyData(200, 0));
    public static final Material<Item> CHORUS_FRUIT = new Material<>(Item.class, "CHORUS_FRUIT", "chorus_fruit", new LegacyData(432, 0));
    public static final Material<MultiDirectional> CHORUS_PLANT = new Material<>(MultiDirectional.class, "CHORUS_PLANT", "chorus_plant", new LegacyData(199, 0));
    public static final Material<StackedBlock> CLAY = new Material<>(StackedBlock.class, "CLAY", "clay", new LegacyData(82, 0));
    public static final Material<Item> CLAY_BALL = new Material<>(Item.class, "CLAY_BALL", "clay", new LegacyData(337, 0));
    public static final Material<Item> CLOCK = new Material<>(Item.class, "WATCH", "CLOCK", "clock", new LegacyData(347, 0));
    public static final Material<Item> COAL = new Material<>(Item.class, "COAL", "coal", "coal", new LegacyData(263, 0));
    public static final Material<StackedBlock> COAL_BLOCK = new Material<>(StackedBlock.class, "COAL_BLOCK", "coal_block", new LegacyData(173, 0));
    public static final Material<StackedBlock> COAL_ORE = new Material<>(StackedBlock.class, "COAL_ORE", "coal_ore", new LegacyData(16, 0));
    public static final Material<StackedBlock> COARSE_DIRT = new Material<>(StackedBlock.class, "DIRT", "COARSE_DIRT", "dirt", "coarse_dirt", new LegacyData(3, 1));
    public static final Material<StackedBlock> COBBLESTONE = new Material<>(StackedBlock.class, "COBBLESTONE", "cobblestone", new LegacyData(4, 0));
    public static final Material<Slab> COBBLESTONE_SLAB = new Material<>(Slab.class, "STEP", "COBBLESTONE_SLAB", "stone_slab", "cobblestone_slab", new LegacyData(44, 3));
    public static final Material<Stairs> COBBLESTONE_STAIRS = new Material<>(Stairs.class, "COBBLESTONE_STAIRS", "COBBLESTONE_STAIRS", "stone_stairs", "cobblestone_stairs", new LegacyData(67, 0));
    public static final Material<Divider> COBBLESTONE_WALL = new Material<>(Divider.class, "COBBLE_WALL", "COBBLESTONE_WALL", "cobblestone_wall", new LegacyData(139, 0));
    public static final Material<StackedBlock> COBWEB = new Material<>(StackedBlock.class, "WEB", "COBWEB", "cobweb", new LegacyData(30, 0));
    public static final Material<Cocoa> COCOA = new Material<>(Cocoa.class, "COCOA", "cocoa", new LegacyData(127, 0));
    public static final Material<Item> COCOA_BEANS = new Material<>(Item.class, "INK_SACK", "COCOA_BEANS", "dye", "cocoa_beans", new LegacyData(351, 3));
    public static final Material<Item> COD = new Material<>(Item.class, "RAW_FISH", "COD", "fish","cod", new LegacyData(349, 0));
    @v113 public static final Material<Item> COD_BUCKET = new Material<>(Item.class, "COD_BUCKET", "cod_bucket");
    @v113 public static final Material<Item> COD_SPAWN_EGG = new Material<>(Item.class, "COD_SPAWN_EGG", "cod_spawn_egg");
    public static final Material<CommandBlock> COMMAND_BLOCK = new Material<>(CommandBlock.class, "COMMAND", "COMMAND_BLOCK", "command_block", new LegacyData(137, 0));
    public static final Material<Item> COMMAND_BLOCK_MINECART = new Material<>(Item.class, "COMMAND_MINECART", "COMMAND_BLOCK_MINECART", "command_block_minecart", new LegacyData(422, 0));
    public static final Material<Comparator> COMPARATOR = new Material<>(Comparator.class, "REDSTONE_COMPARATOR_OFF", "COMPARATOR", "unpowered_comparator", "powered_comparator", new LegacyData(149, 0));
    public static final Material<Item> COMPASS = new Material<>(Item.class, "COMPASS", "compass", new LegacyData(345, 0));
    @v113 public static final Material<StackedBlock> CONDUIT = new Material<>(StackedBlock.class, "CONDUIT", "conduit");
    public static final Material<Item> COOKED_BEEF = new Material<>(Item.class, "COOKED_BEEF", "cooked_beef", new LegacyData(364, 0));
    public static final Material<Item> COOKED_CHICKEN = new Material<>(Item.class, "COOKED_CHICKEN", "cooked_chicken", new LegacyData(366, 0));
    public static final Material<Item> COOKED_COD = new Material<>(Item.class, "COOKED_FISH", "COOKED_COD", "cooked_fish", "cooked_cod", new LegacyData(350, 0));
    public static final Material<Item> COOKED_MUTTON = new Material<>(Item.class, "COOKED_MUTTON", "cooked_mutton", new LegacyData(424, 0));
    public static final Material<Item> COOKED_PORKCHOP = new Material<>(Item.class, "GRILLED_PORK", "COOKED_PORKCHOP", "cooked_porkchop", new LegacyData(320, 0));
    public static final Material<Item> COOKED_RABBIT = new Material<>(Item.class, "COOKED_RABBIT", "cooked_rabbit", new LegacyData(412, 0));
    public static final Material<Item> COOKED_SALMON = new Material<>(Item.class, "COOKED_FISH", "COOKED_SALMON", "cooked_fish", "cooked_salmon", new LegacyData(350, 1));
    public static final Material<Item> COOKIE = new Material<>(Item.class, "COOKIE", "cookie", new LegacyData(357, 0));
    public static final Material<Item> COW_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "COW_SPAWN_EGG", "spawn_egg", "cow_spawn_egg", new LegacyData(383, 92));
    public static final Material<StackedBlock> CRACKED_STONE_BRICKS = new Material<>(StackedBlock.class, "SMOOTH_BRICK", "CRACKED_STONE_BRICKS", "stonebrick", "cracked_stone_bricks", new LegacyData(98, 2));
    public static final Material<StackedBlock> CRAFTING_TABLE = new Material<>(StackedBlock.class, "WORKBENCH", "CRAFTING_TABLE", "crafting_table", new LegacyData(58, 0));
    public static final Material<Rotatable> CREEPER_HEAD = new Material<>(Rotatable.class, "SKULL", "CREEPER_HEAD", "skull", "creeper_head", new LegacyData(144, 4));
    public static final Material<Item> CREEPER_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "CREEPER_SPAWN_EGG", "spawn_egg", "creeper_spawn_egg", new LegacyData(383, 50));
    public static final Material<Directional> CREEPER_WALL_HEAD = new Material<>(Directional.class, "SKULL", "CREEPER_WALL_HEAD", "skull", "creeper_wall_head", new LegacyData(144, 4));
    public static final Material<StackedBlock> CUT_RED_SANDSTONE = new Material<>(StackedBlock.class, "RED_SANDSTONE", "CUT_RED_SANDSTONE", "red_sandstone", "cut_red_sandstone", new LegacyData(179, 2));
    public static final Material<StackedBlock> CUT_SANDSTONE = new Material<>(StackedBlock.class, "SANDSTONE", "CUT_SANDSTONE", "sandstone", "cut_sandstone", new LegacyData(24, 2));
    public static final Material<Banner> CYAN_BANNER = new Material<>(Banner.class, "STANDING_BANNER", "CYAN_BANNER", "banner", "cyan_banner", 16, new LegacyData(425, 6));
    public static final Material<Bed> CYAN_BED = new Material<>(Bed.class, "BED_BLOCK", "CYAN_BED", "bed", "cyan_bed", 1, new LegacyData(355, 9));
    public static final Material<StackedBlock> CYAN_CARPET = new Material<>(StackedBlock.class, "CARPET", "CYAN_CARPET", "carper", "cyan_carpet", new LegacyData(171, 9));
    public static final Material<StackedBlock> CYAN_CONCRETE = new Material<>(StackedBlock.class, "CONCRETE", "CYAN_CONCRETE", "concrete", "cyan_concrete", new LegacyData(251, 9));
    public static final Material<StackedBlock> CYAN_CONCRETE_POWDER = new Material<>(StackedBlock.class, "CONCRETE_POWDER", "CYAN_CONCRETE_POWDER", "concrete_powder", "cyan_concrete_powder", new LegacyData(252, 9));
    public static final Material<Item> CYAN_DYE = new Material<>(Item.class, "INK_SACK", "CYAN_DYE", "dye", "cyan_dye", new LegacyData(351, 6));
    public static final Material<Directional> CYAN_GLAZED_TERRACOTTA = new Material<>(Directional.class, "CYAN_GLAZED_TERRACOTTA", "cyan_glazed_terracotta", new LegacyData(244, 0));
    public static final Material<Directional> CYAN_SHULKER_BOX = new Material<>(Directional.class, "CYAN_SHULKER_BOX", "cyan_shulker_box", new LegacyData(228, 0));
    public static final Material<StackedBlock> CYAN_STAINED_GLASS = new Material<>(StackedBlock.class, "STAINED_GLASS", "CYAN_STAIMED_GLASS", "stained_glass", "cyan_stained_glass", new LegacyData(95, 9));
    public static final Material<Divider> CYAN_STAINED_GLASS_PANE = new Material<>(Divider.class, "STAINED_GLASS_PANE", "CYAB_STAINED_GLASS_PANE", "stained_glass_pane", "cyan_stained_glass_pane", new LegacyData(160, 9));
    public static final Material<StackedBlock> CYAN_TERRACOTTA = new Material<>(StackedBlock.class, "STAINED_CLAY", "CYAN_TERRACOTTA", "stained_hardened_clay", "cyan_terracotta", new LegacyData(159, 9));
    public static final Material<Banner> CYAN_WALL_BANNER = new Material<>(Banner.class, "WALL_BANNER", "CYAN_WALL_BANNER", "standing_banner", "wall_banner", new LegacyData(177, 9));
    public static final Material<StackedBlock> CYAN_WOOL = new Material<>(StackedBlock.class, "WOOL", "CYAN_WOOL", "wool", "cyan_wool", new LegacyData(35, 9));
    
    
    public static final Material<Directional> DAMAGED_ANVIL = new Material<>(Directional.class, "ANVIL", "DAMAGED_ANVIL", "anvil", "damaged_anvil", new LegacyData(145, 2));
    public static final Material<StackedBlock> DANDELION = new Material<>(StackedBlock.class, "YELLOW_FLOWER", "DANDELION", "yellow_flower", "dandelion", new LegacyData(37, 0));
    public static final Material<Item> DANDELION_YELLOW = new Material<>(Item.class, "INK_SACK", "DANDELION_YELLOW", "dye", "dancelion_yellow", new LegacyData(351, 11));
    public static final Material<Item> DARK_OAK_BOAT = new Material<>(Item.class, "BOAT_DARK_OAK", "DARK_OAK_BOAT", "dark_oak_boat", 1, new LegacyData(448, 0));
    @v113 public static final Material<Switch> DARK_OAK_BUTTON = new Material<>(Switch.class, "DARK_OAK_BUTTON", "dark_oak_button");
    public static final Material<Door> DARK_OAK_DOOR = new Material<>(Door.class, "DARK_OAK_DOOR", "dark_oak_door", new LegacyData(197, 0));
    public static final Material<Divider> DARK_OAK_FENCE = new Material<>(Divider.class, "DARK_OAK_FENCE", "dark_oak_fence", new LegacyData(191, 0));
    public static final Material<Gate> DARK_OAK_FENCE_GATE = new Material<>(Gate.class, "DARK_OAK_FENCE_GATE", "dark_oak_fence_gate", new LegacyData(186, 0));
    public static final Material<Leaves> DARK_OAK_LEAVES = new Material<>(Leaves.class, "LEAVES_2", "DARK_OAK_LEAVES", "leaves2", "dark_oak_leaves", new LegacyData(161, 1));
    public static final Material<Pillar> DARK_OAK_LOG = new Material<>(Pillar.class, "LOG_2", "DARK_OAK_LOG", "log2", "dark_oak_log", new LegacyData(162, 1));
    public static final Material<StackedBlock> DARK_OAK_PLANKS = new Material<>(StackedBlock.class, "WOOD", "DARK_OAK_PLANKS", "planks", "dark_oak_planks", new LegacyData(5, 5));
    @v113 public static final Material<PressurePlate> DARK_OAK_PRESSURE_PLATE = new Material<>(PressurePlate.class, "DARK_OAK_PRESSURE_PLATE", "dark_oak_pressure_plate");
    public static final Material<Sapling> DARK_OAK_SAPLING = new Material<>(Sapling.class, "SAPLING", "DARK_OAK_SAPLING", "sapling", "dark_oak_sapling", new LegacyData(6, 5));
    public static final Material<Slab> DARK_OAK_SLAB = new Material<>(Slab.class, "WOOD_STEP", "DARK_OAK_SLAB", "wooden_slab", "dark_oak_slab", new LegacyData(126, 5));
    public static final Material<Stairs> DARK_OAK_STAIRS = new Material<>(Stairs.class, "DARK_OAK_STAIRS", "dark_oak_stairs", new LegacyData(164, 0));
    @v113 public static final Material<Trapdoor> DARK_OAK_TRAPDOOR = new Material<>(Trapdoor.class, "DARK_OAK_TRAPDOOR", "dark_oak_trapdoor");
    public static final Material<Pillar> DARK_OAK_WOOD = new Material<>(Pillar.class, "LOG_2", "DARK_OAK_WOOD", "log2", "dark_oak_wood", new LegacyData(162, 13));
    public static final Material<StackedBlock> DARK_PRISMARINE = new Material<>(StackedBlock.class, "PRISMARINE", "DARK_PRISMARINE", "prismarine", "dark_prismarine", new LegacyData(168, 2));
    @v113 public static final Material<Slab> DARK_PRISMARINE_SLAB = new Material<>(Slab.class, "DARK_PRISMARINE_SLAB", "dark_prismarine_slab");
    @v113 public static final Material<Stairs> DARK_PRISMARINE_STAIRS = new Material<>(Stairs.class, "DARK_PRISMARINE_STAIRS", "dark_prismarine_stairs");
    public static final Material<DaylightDetector> DAYLIGHT_DETECTOR = new Material<>(DaylightDetector.class, "DAYLIGHT_DETECTOR", "daylight_detector", new LegacyData(151, 0));
    @v113 public static final Material<StackedBlock> DEAD_BRAIN_CORAL_BLOCK = new Material<>(StackedBlock.class, "DEAD_BRAIN_CORAL_BLOCK", "dead_brain_coral_block");
    @v113 public static final Material<Waterlogged> DEAD_BRAIN_CORAL_FAN = new Material<>(Waterlogged.class, "DEAD_BRAIN_CORAL_FAN", "dead_brain_coral_fan");
    @v113 public static final Material<WallFan> DEAD_BRAIN_CORAL_WALL_FAN = new Material<>(WallFan.class, "DEAD_BRAIN_CORAL_WALL_FAN", "dead_brain_coral_wall_fan");
    @v113 public static final Material<StackedBlock> DEAD_BUBBLE_CORAL_BLOCK = new Material<>(StackedBlock.class, "DEAD_BUBBLE_CORAL_BLOCK", "dead_bubble_coral_block");
    @v113 public static final Material<Waterlogged> DEAD_BUBBLE_CORAL_FAN = new Material<>(Waterlogged.class, "DEAD_BUBBLE_CORAL_FAN", "dead_bubble_coral_fan");
    @v113 public static final Material<WallFan> DEAD_BUBBLE_CORAL_WALL_FAN = new Material<>(WallFan.class, "DEAD_BUBBLE_CORAL_WALL_FAN", "dead_bubble_coral_wall_fan");
    public static final Material<StackedBlock> DEAD_BUSH = new Material<>(StackedBlock.class, "DEAD_BUSH", "dead_bush", new LegacyData(32, 0));
    @v113 public static final Material<StackedBlock> DEAD_FIRE_CORAL_BLOCK = new Material<>(StackedBlock.class, "DEAD_FIRE_CORAL_BLOCK", "dead_fire_coral_block");
    @v113 public static final Material<Waterlogged> DEAD_FIRE_CORAL_FAN = new Material<>(Waterlogged.class, "DEAD_FIRE_DORAL_FAN", "dead_fire_coral_fan");
    @v113 public static final Material<WallFan> DEAD_FIRE_CORAL_WALL_FAN = new Material<>(WallFan.class, "DEAD_FIRE_CORAL_WALL_FAN", "dead_fire_coral_wall_fan");
    @v113 public static final Material<StackedBlock> DEAD_HORN_CORAL_BLOCK = new Material<>(StackedBlock.class, "DEAD_HORN_CORAL_BLOCK", "dead_horn_coral_block");
    @v113 public static final Material<Waterlogged> DEAD_HORN_CORAL_FAN = new Material<>(Waterlogged.class, "DEAD_HORN_CORAL_FAN", "dead_horn_coral_fan");
    @v113 public static final Material<WallFan> DEAD_HORN_CORAL_WALL_FAN = new Material<>(WallFan.class, "DEAD_HORN_CORAL_WALL_FAN", "dead_horn_coral_wall_fan");
    @v113 public static final Material<StackedBlock> DEAD_TUBE_CORAL_BLOCK = new Material<>(StackedBlock.class, "DEAD_TUBE_CORAL_BLOCK", "dead_tube_coral_block");
    @v113 public static final Material<Waterlogged> DEAD_TUBE_CORAL_FAN = new Material<>(Waterlogged.class, "DEAD_TUBE_CORAL_FAN", "dead_tube_coral_fan");
    @v113 public static final Material<WallFan> DEAD_TUBE_CORAL_WALL_FAN = new Material<>(WallFan.class, "DEAD_TUBE_CORAL_WALL_FAN", "dead_tube_coral_wall_fan");
    @v113 public static final Material<Item> DEBUG_STICK = new Material<>(Item.class, "DEBUG_STICK", "debug_stick");
    public static final Material<RedstoneRail> DETECTOR_RAIL = new Material<>(RedstoneRail.class, "DETECTOR_RAIL", "detector_rail", new LegacyData(28, 0));
    public static final Material<Item> DIAMOND = new Material<>(Item.class, "DIAMOND", "diamond", new LegacyData(264, 0));
    public static final Material<Item> DIAMOND_AXE = new Material<>(Item.class, "DIAMOND_AXE", "diamond_axe", 1, new LegacyData(279, 0));
    public static final Material<StackedBlock> DIAMOND_BLOCK = new Material<>(StackedBlock.class, "DIAMOND_BLOCK", "diamond_block", new LegacyData(57, 0));
    public static final Material<Item> DIAMOND_BOOTS = new Material<>(Item.class, "DIAMOND_BOOTS", "diamond_boots", 1, new LegacyData(313, 0));
    public static final Material<Item> DIAMOND_CHESTPLATE = new Material<>(Item.class, "DIAMOND_CHESTPLATE", "diamond_chestplate", 1, new LegacyData(311, 0));
    public static final Material<Item> DIAMOND_HELMET = new Material<>(Item.class, "DIAMOND_HELMET", "diamond_helmet", 1, new LegacyData(310, 0));
    public static final Material<Item> DIAMOND_HOE = new Material<>(Item.class, "DIAMOND_HOE", "diamond_hoe", 1, new LegacyData(293, 1));
    public static final Material<Item> DIAMOND_HORSE_ARMOR = new Material<>(Item.class, "DIAMOND_BARDING", "DIAMOND_HORSE_ARMOR", "diamond_horse_armor", 1, new LegacyData(419, 0));
    public static final Material<Item> DIAMOND_LEGGINGS = new Material<>(Item.class, "DIAMOND_LEGGINGS", "diamond_leggings", 1, new LegacyData(312, 0));
    public static final Material<StackedBlock> DIAMOND_ORE = new Material<>(StackedBlock.class, "DIAMOND_ORE", "diamond_ore", new LegacyData(56, 0));
    public static final Material<Item> DIAMOND_PICKAXE = new Material<>(Item.class, "DIAMOND_PICKAXE", "diamond_pickaxe", 1, new LegacyData(278, 0));
    public static final Material<Item> DIAMOND_SHOVEL = new Material<>(Item.class, "DIAMOND_SPADE", "DIAMOND_SHOVEL", "diamond_shovel", 1, new LegacyData(277, 0));
    public static final Material<Item> DIAMOND_SWORD = new Material<>(Item.class, "DIAMOND_SWORD", "diamond_sword", 1, new LegacyData(276, 0));
    public static final Material<StackedBlock> DIORITE = new Material<>(StackedBlock.class, "STONE", "DIORITE", "stone", "diorite", new LegacyData(1, 3));
    public static final Material<StackedBlock> DIRT = new Material<>(StackedBlock.class, "DIRT", "dirt", new LegacyData(3, 0));
    public static final Material<Triggered> DISPENSER = new Material<>(Triggered.class, "DISPENSER", "dispenser", new LegacyData(23, 0));
    @v113 public static final Material<Item> DOLPHIN_SPAWN_EGG = new Material<>(Item.class, "DOLPHIN_SPAWN_EGG", "dolphin_spawn_egg");
    public static final Material<Item> DONKEY_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "DONKEY_SPAWN_EGG", "spawn_egg", "donkey_spawn_egg", new LegacyData(383, 31));
    public static final Material<Item> DRAGON_BREATH = new Material<>(Item.class, "DRAGONS_BREATH", "DRAGON_BREATH", "dragon_breath", new LegacyData(437, 0));
    public static final Material<StackedBlock> DRAGON_EGG = new Material<>(StackedBlock.class, "DRAGON_EGG", "dragon_egg", new LegacyData(122, 0));
    public static final Material<Rotatable> DRAGON_HEAD = new Material<>(Rotatable.class, "SKULL", "DRAGON_HEAD", "skull", "dragon_head", new LegacyData(144, 5));
    public static final Material<Directional> DRAGON_WALL_HEAD = new Material<>(Directional.class, "SKULL", "DRAGON_WALL_HEAD", "skull", "dragon_wall_head", new LegacyData(144, 5));
    @v113 public static final Material<Item> DRIED_KELP = new Material<>(Item.class, "DRIED_KELP", "dried_kelp");
    public static final Material<StackedBlock> DRIED_KELP_BLOCK = new Material<>(StackedBlock.class, "DRIED_KELP_BLOCK", "dried_kelp_block");
    public static final Material<Triggered> DROPPER = new Material<>(Triggered.class, "DROPPER", "dropper", new LegacyData(158, 0));
    @v113 public static final Material<Item> DROWNED_SPAWN_EGG = new Material<>(Item.class, "DROWNED_SPAWN_EGG", "drowned_spawn_egg");
    
    
    
    public static final Material<Item> EGG = new Material<>(Item.class, "EGG", "egg", 16, new LegacyData(344, 0));
    public static final Material<Item> ELDER_GUARDIAN_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "ELDER_GUARDIAN_SPAWN_EGG", "spawn_egg", "elder_guardian_spawn_egg", new LegacyData(383, 4));
    public static final Material<Item> ELYTRA = new Material<>(Item.class, "ELYTRA", "elytra", 1, new LegacyData(443, 0));
    public static final Material<Item> EMERALD = new Material<>(Item.class, "EMERALD", "emerald", new LegacyData(388, 0));
    public static final Material<StackedBlock> EMERALD_BLOCK = new Material<>(StackedBlock.class, "EMERALD_BLOCK", "emerald_block", new LegacyData(133, 0));
    public static final Material<StackedBlock> EMERALD_ORE = new Material<>(StackedBlock.class, "EMERALD_ORE", "emerald_ore", new LegacyData(129, 0));
    public static final Material<Item> ENCHANTED_BOOK = new Material<>(Item.class, "ENCHANTED_BOOK", "enchanted_book", 1, new LegacyData(403, 0));
    public static final Material<Item> ENCHANTED_GOLDEN_APPLE = new Material<>(Item.class, "GOLDEN_APPLE", "ENCHANTED_GOLDEN_APPLE", "golden_apple", "enchanted_golden_apple", new LegacyData(322, 0));
    public static final Material<StackedBlock> ENCHANTING_TABLE = new Material<>(StackedBlock.class, "ENCHANTMENT_TABLE", "ENCHANTING_TABLE", "enchanting_table", new LegacyData(116, 0));
    public static final Material<Item> ENDERMAN_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "ENDERMAN_SPAWN_EGG", "spawn_egg", "enderman_spawn_egg", new LegacyData(383, 58));
    public static final Material<Item> ENDERMITE_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "ENDERMITE_SPAWN_EGG", "spawn_egg", "endermite_spawn_egg", new LegacyData(383, 67));
    public static final Material<EnderChest> ENDER_CHEST = new Material<>(EnderChest.class, "ENDER_CHEST", "ender_chest", new LegacyData(130, 0));
    public static final Material<Item> ENDER_EYE = new Material<>(Item.class, "EYE_OF_ENDER", "ENDER_EYE", "eye_of_ender", "ender_eye", new LegacyData(381, 0));
    public static final Material<Item> ENDER_PEARL = new Material<>(Item.class, "ENDER_PEARL", "ender_peark", 16, new LegacyData(368, 0));
    public static final Material<Item> END_CRYSTAL = new Material<>(Item.class, "END_CRYSTAL", "end_crystal", new LegacyData(426, 0));
    public static final Material<StackedBlock> END_GATEWAY = new Material<>(StackedBlock.class, "END_GATEWAY", "end_gateway", new LegacyData(209, 0));
    public static final Material<StackedBlock> END_PORTAL = new Material<>(StackedBlock.class, "ENDER_PORTAL", "END_PORTAL", "end_portal", new LegacyData(119, 0));
    public static final Material<EndPortalFrame> END_PORTAL_FRAME = new Material<>(EndPortalFrame.class, "ENDER_PORTAL_FRAME", "END_PORTAL_FRAME", "end_portal_frame", new LegacyData(120, 0));
    public static final Material<EndRod> END_ROD = new Material<>(EndRod.class, "END_ROD", "end_rod", new LegacyData(198, 0));
    public static final Material<StackedBlock> END_STONE = new Material<>(StackedBlock.class, "ENDER_STONE", "END_STONE", "end_stone", new LegacyData(121, 0));
    public static final Material<StackedBlock> END_STONE_BRICKS = new Material<>(StackedBlock.class, "END_BRICKS", "END_STONE_BRICKS", "end_bricks", "end_stone_bricks", new LegacyData(206, 0));
    public static final Material<Item> EVOKER_SPAWN_EGG = new Material<>(Item.class, "MONSTER_EGG", "EVOKER_SPAWN_EGG", "spawn_egg", "evoker_spawn_egg", new LegacyData(383, 34));
    public static final Material<Item> EXPERIENCE_BOTTLE = new Material<>(Item.class, "EXP_BOTTLE", "EXPERIENCE_BOTTLE", "experience_bottle", new LegacyData(384, 0));
    
    
    
    public static final Material<Farmland> FARMLAND = new Material<>(Farmland.class, "SOIL", "FARMLAND", "farmland", new LegacyData(60, 0));
    public static final Material<Item> FEATHER = new Material<>(Item.class, "FEATHER", "feather", new LegacyData(288, 0));
    public static final Material<Item> FERMENTED_SPIDER_EYE = new Material<>(Item.class, "FERMENTED_SPIDER_EYE", "fermented_spider_eye", new LegacyData(376, 0));
    public static final Material<StackedBlock> FERN = new Material<>(StackedBlock.class, "LONG_GRASS", "FERN", "tallgrass", "fern", new LegacyData(31, 2));
    public static final Material<Item> FILLED_MAP = new Material<>(Item.class, "MAP", "FILLED_MAP", "filled_map", new LegacyData(358, 0));
    public static final Material<Fire> FIRE = new Material<>(Fire.class, "FIRE", "fire", new LegacyData(51, 0));
    public static final Material<Item> FIREWORK_ROCKET = new Material<>(Item.class, "FIREWORK", "FIREWORK_ROCKET", "fireworks", "firework_rocket", new LegacyData(401, 0));
    public static final Material<Item> FIREWORK_STAR = new Material<>(Item.class, "FIREWORK_CHARGE", "FIREWORK_STAR", "firework_charge", "firework_star", new LegacyData(402, 0));
    public static final Material<Item> FIRE_CHARGE = new Material<>(Item.class, "FIREBALL", "FIRE_CHARGE", "fire_charge", new LegacyData(385, 0));
    @v113 public static final Material<StackedBlock> FIRE_CORAL = new Material<>(StackedBlock.class, "FIRE_CORAL", "fire_coral");
    @v113 public static final Material<StackedBlock> FIRE_CORAL_BLOCK = new Material<>(StackedBlock.class, "FIRE_CORAL_BLOCK", "fire_coral_block");
    @v113 public static final Material<Waterlogged> FIRE_CORAL_FAN = new Material<>(Waterlogged.class, "FIRE_CORAL_FAN", "fire_coral_fan");
    @v113 public static final Material<WallFan> FIRE_CORAL_WALL_FAN = new Material<>(WallFan.class, "FIRE_CORAL_WALL_FAN", "fire_coral_wall_fan");
    public static final Material<Item> FISHING_ROD = new Material<>(Item.class, "FISHING_ROD", "fishing_rod", 1, new LegacyData(346, 0));
    public static final Material<Item> FLINT = new Material<>(Item.class, "FLINT", "flint", new LegacyData(318, 0));
    public static final Material<Item> FLINT_AND_STEEL = new Material<>(Item.class, "FLINT_AND_STEEL", "flint_and_steel", 1, new LegacyData(259, 0));
    public static final Material<StackedBlock> FLOWER_POT = new Material<>(StackedBlock.class, "FLOWER_POT", "flower_pot", new LegacyData(140, 0));
    public static final Material<Ageable> FROSTED_ICE = new Material<>(Ageable.class, "FROSTED_ICE", "frosted_ice", new LegacyData(212, 0));
    public static final Material<Furnace> FURNACE = new Material<>(Furnace.class, "FURNACE", "furnace", new LegacyData(61, 0));
    public static final Material<Item> FURNACE_MINECART = new Material<>(Item.class, "POWERED_MINECART", "FURNACE_MINECART", "furnace_minecart", 1, new LegacyData(343, 0));

    
    public static final Material<Item> GHAST_SPAWN_EGG = new Material<>();
    public static final Material<Item> GHAST_TEAR = new Material<>();
    public static final Material<StackedBlock> GLASS = new Material<>();
    public static final Material<Item> GLASS_BOTTLE = new Material<>();
    public static final Material<Divider> GLASS_PANE = new Material<>();
    public static final Material<Item> GLISTERING_MELON_SLICE = new Material<>();
    public static final Material<StackedBlock> GLOWSTONE = new Material<>();
    public static final Material<Item> GLOWSTONE_DUST = new Material<>();
    public static final Material<Item> GOLDEN_APPLE = new Material<>();
    public static final Material<Item> GOLDEN_AXE = new Material<>();
    public static final Material<Item> GOLDEN_BOOTS = new Material<>();
    public static final Material<Item> GOLDEN_CARROT = new Material<>();
    public static final Material<Item> GOLDEN_CHESTPLATE = new Material<>();
    public static final Material<Item> GOLDEN_HELMET = new Material<>();
    public static final Material<Item> GOLDEN_HOE = new Material<>();
    public static final Material<Item> GOLDEN_HORSE_ARMOR = new Material<>();
    public static final Material<Item> GOLDEN_LEGGINGS = new Material<>();
    public static final Material<Item> GOLDEN_PICKAXE = new Material<>();
    public static final Material<Item> GOLDEN_SHOVEL = new Material<>();
    public static final Material<Item> GOLDEN_SWORD = new Material<>();
    public static final Material<StackedBlock> GOLD_BLOCK = new Material<>();
    public static final Material<Item> GOLD_INGOT = new Material<>();
    public static final Material<Item> GOLD_NUGGET = new Material<>();
    public static final Material<StackedBlock> GOLD_ORE = new Material<>();
    public static final Material<StackedBlock> GRANITE = new Material<>();
    public static final Material<StackedBlock> GRASS = new Material<>();
    public static final Material<StackedBlock> GRASS_BLOCK = new Material<>();
    public static final Material<StackedBlock> GRASS_PATH = new Material<>();
    public static final Material<StackedBlock> GRAVEL = new Material<>();
    public static final Material<Banner> GRAY_BANNER = new Material<>();
    public static final Material<Bed> GRAY_BED = new Material<>();
    public static final Material<StackedBlock> GRAY_CARPET = new Material<>();
    public static final Material<StackedBlock> GRAY_CONCRETE = new Material<>();
    public static final Material<StackedBlock> GRAY_CONCRETE_POWDER = new Material<>();
    public static final Material<Item> GRAY_DYE = new Material<>();
    public static final Material<Directional> GRAY_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Directional> GRAY_SHULKER_BOX = new Material<>();
    public static final Material<StackedBlock> GRAY_STAINED_GLASS = new Material<>();
    public static final Material<Divider> GRAY_STAINED_GLASS_PANE = new Material<>();
    public static final Material<StackedBlock> GRAY_TERRACOTTA = new Material<>();
    public static final Material<Banner> GRAY_WALL_BANNER = new Material<>();
    public static final Material<StackedBlock> GRAY_WOOL = new Material<>();
    public static final Material<Banner> GREEN_BANNER = new Material<>();
    public static final Material<Bed> GREEN_BED = new Material<>();
    public static final Material<StackedBlock> GREEN_CARPET = new Material<>();
    public static final Material<StackedBlock> GREEN_CONCRETE = new Material<>();
    public static final Material<StackedBlock> GREEN_CONCRETE_POWDER = new Material<>();
    public static final Material<Directional> GREEN_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> GREEN_SHULKER_BOX = new Material<>();
    public static final Material<Block> GREEN_STAINED_GLASS = new Material<>();
    public static final Material<Block> GREEN_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> GREEN_TERRACOTTA = new Material<>();
    public static final Material<Block> GREEN_WALL_BANNER = new Material<>();
    public static final Material<Block> GREEN_WOOL = new Material<>();
    public static final Material<Block> GUARDIAN_SPAWN_EGG = new Material<>();
    public static final Material<Block> GUNPOWDER = new Material<>();
    
    
    public static final Material<Block> HAY_BLOCK = new Material<>();
    public static final Material<Block> HEART_OF_THE_SEA = new Material<>();
    public static final Material<Block> HEAVY_WEIGHTED_PRESSURE_PLATE = new Material<>();
    public static final Material<Block> HOPPER = new Material<>();
    public static final Material<Block> HOPPER_MINECART = new Material<>();
    public static final Material<Block> HORN_CORAL = new Material<>();
    public static final Material<Block> HORN_CORAL_BLOCK = new Material<>();
    public static final Material<Block> HORN_CORAL_FAN = new Material<>();
    public static final Material<Block> HORN_CORAL_WALL_FAN = new Material<>();
    public static final Material<Block> HORSE_SPAWN_EGG = new Material<>();
    public static final Material<Block> HUSK_SPAWN_EGG = new Material<>();*/
    
    /*
    public static final Material<Block> ICE = new Material<>();
    public static final Material<Block> INFESTED_CHISELED_STONE_BRICKS = new Material<>();
    public static final Material<Block> INFESTED_COBBLESTONE = new Material<>();
    public static final Material<Block> INFESTED_CRACKED_STONE_BRICKS = new Material<>();
    public static final Material<Block> INFESTED_MOSSY_STONE_BRICKS = new Material<>();
    public static final Material<Block> INFESTED_STONE = new Material<>();
    public static final Material<Block> INFESTED_STONE_BRICKS = new Material<>();
    public static final Material<Block> INK_SAC = new Material<>();
    public static final Material<Block> IRON_AXE = new Material<>();
    public static final Material<Block> IRON_BARS = new Material<>();
    public static final Material<Block> IRON_BLOCK = new Material<>();
    public static final Material<Block> IRON_BOOTS = new Material<>();
    public static final Material<Block> IRON_CHESTPLATE = new Material<>();
    public static final Material<Block> IRON_DOOR = new Material<>();
    public static final Material<Block> IRON_HELMET = new Material<>();
    public static final Material<Block> IRON_HOE = new Material<>();
    public static final Material<Block> IRON_HORSE_ARMOR = new Material<>();
    public static final Material<Block> IRON_INGOT = new Material<>();
    public static final Material<Block> IRON_LEGGINGS = new Material<>();
    public static final Material<Block> IRON_NUGGET = new Material<>();
    public static final Material<Block> IRON_ORE = new Material<>();
    public static final Material<Block> IRON_PICKAXE = new Material<>();
    public static final Material<Block> IRON_SHOVEL = new Material<>();
    public static final Material<Block> IRON_SWORD = new Material<>();
    public static final Material<Block> IRON_TRAPDOOR = new Material<>();
    public static final Material<Block> ITEM_FRAME = new Material<>();
    
    
    public static final Material<Block> JACK_O_LANTERN = new Material<>();
    public static final Material<Block> JUKEBOX = new Material<>();
    public static final Material<Block> JUNGLE_BOAT = new Material<>();
    public static final Material<Block> JUNGLE_BUTTON = new Material<>();
    public static final Material<Block> JUNGLE_DOOR = new Material<>();
    public static final Material<Block> JUNGLE_FENCE = new Material<>();
    public static final Material<Block> JUNGLE_FENCE_GATE = new Material<>();
    public static final Material<Block> JUNGLE_LEAVES = new Material<>();
    public static final Material<Block> JUNGLE_LOG = new Material<>();
    public static final Material<Block> JUNGLE_PLANKS = new Material<>();
    public static final Material<Block> JUNGLE_PRESSURE_PLATE = new Material<>();
    public static final Material<Block> JUNGLE_SAPLING = new Material<>();
    public static final Material<Block> JUNGLE_SLAB = new Material<>();
    public static final Material<Block> JUNGLE_STAIRS = new Material<>();
    public static final Material<Block> JUNGLE_TRAPDOOR = new Material<>();
    public static final Material<Block> JUNGLE_WOOD = new Material<>();
    
    
    public static final Material<Block> KELP = new Material<>();
    public static final Material<Block> KELP_PLANT = new Material<>();
    public static final Material<Block> KNOWLEDGE_BOOK = new Material<>();
    
    
    public static final Material<Block> LADDER = new Material<>();
    public static final Material<Block> LAPIS_BLOCK = new Material<>();
    public static final Material<Block> LAPIS_LAZULI = new Material<>();
    public static final Material<Block> LAPIS_ORE = new Material<>();
    public static final Material<Block> LARGE_FERN = new Material<>();
    public static final Material<Block> LAVA = new Material<>();
    public static final Material<Block> LAVA_BUCKET = new Material<>();
    public static final Material<Block> LEAD = new Material<>();
    public static final Material<Block> LEATHER = new Material<>();
    public static final Material<Block> LEATHER_BOOTS = new Material<>();
    public static final Material<Block> LEATHER_CHESTPLATE = new Material<>();
    public static final Material<Block> LEATHER_HELMET = new Material<>();
    public static final Material<Block> LEATHER_LEGGINGS = new Material<>();
    public static final Material<Block> LEVER = new Material<>();
    public static final Material<Block> LIGHT_BLUE_BANNER = new Material<>();
    public static final Material<Block> LIGHT_BLUE_BED = new Material<>();
    public static final Material<Block> LIGHT_BLUE_CARPET = new Material<>();
    public static final Material<Block> LIGHT_BLUE_CONCRETE = new Material<>();
    public static final Material<Block> LIGHT_BLUE_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> LIGHT_BLUE_DYE = new Material<>();
    public static final Material<Block> LIGHT_BLUE_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> LIGHT_BLUE_SHULKER_BOX = new Material<>();
    public static final Material<Block> LIGHT_BLUE_STAINED_GLASS = new Material<>();
    public static final Material<Block> LIGHT_BLUE_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> LIGHT_BLUE_TERRACOTTA = new Material<>();
    public static final Material<Block> LIGHT_BLUE_WALL_BANNER = new Material<>();
    public static final Material<Block> LIGHT_BLUE_WOOL = new Material<>();
    public static final Material<Block> LIGHT_GRAY_BANNER = new Material<>();
    public static final Material<Block> LIGHT_GRAY_BED = new Material<>();
    public static final Material<Block> LIGHT_GRAY_CARPET = new Material<>();
    public static final Material<Block> LIGHT_GRAY_CONCRETE = new Material<>();
    public static final Material<Block> LIGHT_GRAY_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> LIGHT_GRAY_DYE = new Material<>();
    public static final Material<Block> LIGHT_GRAY_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> LIGHT_GRAY_SHULKER_BOX = new Material<>();
    public static final Material<Block> LIGHT_GRAY_STAINED_GLASS = new Material<>();
    public static final Material<Block> LIGHT_GRAY_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> LIGHT_GRAY_TERRACOTTA = new Material<>();
    public static final Material<Block> LIGHT_GRAY_WALL_BANNER = new Material<>();
    public static final Material<Block> LIGHT_GRAY_WOOL = new Material<>();
    public static final Material<Block> LIGHT_WEIGHTED_PRESSURE_PLATE = new Material<>();
    public static final Material<Block> LILAC = new Material<>();
    public static final Material<Block> LILY_PAD = new Material<>();
    public static final Material<Block> LIME_BANNER = new Material<>();
    public static final Material<Block> LIME_BED = new Material<>();
    public static final Material<Block> LIME_CARPET = new Material<>();
    public static final Material<Block> LIME_CONCRETE = new Material<>();
    public static final Material<Block> LIME_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> LIME_DYE = new Material<>();
    public static final Material<Block> LIME_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> LIME_SHULKER_BOX = new Material<>();
    public static final Material<Block> LIME_STAINED_GLASS = new Material<>();
    public static final Material<Block> LIME_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> LIME_TERRACOTTA = new Material<>();
    public static final Material<Block> LIME_WALL_BANNER = new Material<>();
    public static final Material<Block> LIME_WOOL = new Material<>();
    public static final Material<Block> LINGERING_POTION = new Material<>();
    public static final Material<Block> LLAMA_SPAWN_EGG = new Material<>();
    
    
    public static final Material<Block> MAGENTA_BANNER = new Material<>();
    public static final Material<Block> MAGENTA_BED = new Material<>();
    public static final Material<Block> MAGENTA_CARPET = new Material<>();
    public static final Material<Block> MAGENTA_CONCRETE = new Material<>();
    public static final Material<Block> MAGENTA_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> MAGENTA_DYE = new Material<>();
    public static final Material<Block> MAGENTA_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> MAGENTA_SHULKER_BOX = new Material<>();
    public static final Material<Block> MAGENTA_STAINED_GLASS = new Material<>();
    public static final Material<Block> MAGENTA_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> MAGENTA_TERRACOTTA = new Material<>();
    public static final Material<Block> MAGENTA_WALL_BANNER = new Material<>();
    public static final Material<Block> MAGENTA_WOOL = new Material<>();
    public static final Material<Block> MAGMA_BLOCK = new Material<>();
    public static final Material<Block> MAGMA_CREAM = new Material<>();
    public static final Material<Block> MAGMA_CUBE_SPAWN_EGG = new Material<>();
    public static final Material<Block> MAP = new Material<>();
    public static final Material<Block> MELON = new Material<>();
    public static final Material<Block> MELON_SEEDS = new Material<>();
    public static final Material<Block> MELON_SLICE = new Material<>();
    public static final Material<Block> MELON_STEM = new Material<>();
    public static final Material<Block> MILK_BUCKET = new Material<>();
    public static final Material<Block> MINECART = new Material<>();
    public static final Material<Block> MOOSHROOM_SPAWN_EGG = new Material<>();
    public static final Material<Block> MOSSY_COBBLESTONE = new Material<>();
    public static final Material<Block> MOSSY_COBBLESTONE_WALL = new Material<>();
    public static final Material<Block> MOSSY_STONE_BRICKS = new Material<>();
    public static final Material<Block> MOVING_PISTON = new Material<>();
    public static final Material<Block> MULE_SPAWN_EGG = new Material<>();
    public static final Material<Block> MUSHROOM_STEM = new Material<>();
    public static final Material<Block> MUSHROOM_STEW = new Material<>();
    public static final Material<Block> MUSIC_DISC_ = new Material<>();
    public static final Material<Block> MUSIC_DISC_ = new Material<>();
    public static final Material<Block> MUSIC_DISC_BLOCKS = new Material<>();
    public static final Material<Block> MUSIC_DISC_CAT = new Material<>();
    public static final Material<Block> MUSIC_DISC_CHIRP = new Material<>();
    public static final Material<Block> MUSIC_DISC_FAR = new Material<>();
    public static final Material<Block> MUSIC_DISC_MALL = new Material<>();
    public static final Material<Block> MUSIC_DISC_MELLOHI = new Material<>();
    public static final Material<Block> MUSIC_DISC_STAL = new Material<>();
    public static final Material<Block> MUSIC_DISC_STRAD = new Material<>();
    public static final Material<Block> MUSIC_DISC_WAIT = new Material<>();
    public static final Material<Block> MUSIC_DISC_WARD = new Material<>();
    public static final Material<Block> MUTTON = new Material<>();
    public static final Material<Block> MYCELIUM = new Material<>();
    
    
    public static final Material<Block> NAME_TAG = new Material<>();
    public static final Material<Block> NAUTILUS_SHELL = new Material<>();
    public static final Material<Block> NETHERRACK = new Material<>();
    public static final Material<Block> NETHER_BRICK = new Material<>();
    public static final Material<Block> NETHER_BRICKS = new Material<>();
    public static final Material<Block> NETHER_BRICK_FENCE = new Material<>();
    public static final Material<Block> NETHER_BRICK_SLAB = new Material<>();
    public static final Material<Block> NETHER_BRICK_STAIRS = new Material<>();
    public static final Material<Block> NETHER_PORTAL = new Material<>();
    public static final Material<Block> NETHER_QUARTZ_ORE = new Material<>();
    public static final Material<Block> NETHER_STAR = new Material<>();
    public static final Material<Block> NETHER_WART = new Material<>();
    public static final Material<Block> NETHER_WART_BLOCK = new Material<>();
    public static final Material<Block> NOTE_BLOCK = new Material<>();
    
    
    public static final Material<Block> OAK_BOAT = new Material<>();
    public static final Material<Block> OAK_BUTTON = new Material<>();
    public static final Material<Block> OAK_DOOR = new Material<>();
    public static final Material<Block> OAK_FENCE = new Material<>();
    public static final Material<Block> OAK_FENCE_GATE = new Material<>();
    public static final Material<Block> OAK_LEAVES = new Material<>();
    public static final Material<Block> OAK_LOG = new Material<>();
    public static final Material<Block> OAK_PLANKS = new Material<>();
    public static final Material<Block> OAK_PRESSURE_PLATE = new Material<>();
    public static final Material<Block> OAK_SAPLING = new Material<>();
    public static final Material<Block> OAK_SLAB = new Material<>();
    public static final Material<Block> OAK_STAIRS = new Material<>();
    public static final Material<Block> OAK_TRAPDOOR = new Material<>();
    public static final Material<Block> OAK_WOOD = new Material<>();
    public static final Material<Block> OBSERVER = new Material<>();
    public static final Material<Block> OBSIDIAN = new Material<>();
    public static final Material<Block> OCELOT_SPAWN_EGG = new Material<>();
    public static final Material<Block> ORANGE_BANNER = new Material<>();
    public static final Material<Block> ORANGE_BED = new Material<>();
    public static final Material<Block> ORANGE_CARPET = new Material<>();
    public static final Material<Block> ORANGE_CONCRETE = new Material<>();
    public static final Material<Block> ORANGE_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> ORANGE_DYE = new Material<>();
    public static final Material<Block> ORANGE_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> ORANGE_SHULKER_BOX = new Material<>();
    public static final Material<Block> ORANGE_STAINED_GLASS = new Material<>();
    public static final Material<Block> ORANGE_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> ORANGE_TERRACOTTA = new Material<>();
    public static final Material<Block> ORANGE_TULIP = new Material<>();
    public static final Material<Block> ORANGE_WALL_BANNER = new Material<>();
    public static final Material<Block> ORANGE_WOOL = new Material<>();
    public static final Material<Block> OXEYE_DAISY = new Material<>();
    
    
    public static final Material<Block> PACKED_ICE = new Material<>();
    public static final Material<Block> PAINTING = new Material<>();
    public static final Material<Block> PAPER = new Material<>();
    public static final Material<Block> PARROT_SPAWN_EGG = new Material<>();
    public static final Material<Block> PEONY = new Material<>();
    public static final Material<Block> PETRIFIED_OAK_SLAB = new Material<>();
    public static final Material<Block> PHANTOM_MEMBRANE = new Material<>();
    public static final Material<Block> PHANTOM_SPAWN_EGG = new Material<>();
    public static final Material<Block> PIG_SPAWN_EGG = new Material<>();
    public static final Material<Block> PINK_BANNER = new Material<>();
    public static final Material<Block> PINK_BED = new Material<>();
    public static final Material<Block> PINK_CARPET = new Material<>();
    public static final Material<Block> PINK_CONCRETE = new Material<>();
    public static final Material<Block> PINK_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> PINK_DYE = new Material<>();
    public static final Material<Block> PINK_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> PINK_SHULKER_BOX = new Material<>();
    public static final Material<Block> PINK_STAINED_GLASS = new Material<>();
    public static final Material<Block> PINK_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> PINK_TERRACOTTA = new Material<>();
    public static final Material<Block> PINK_TULIP = new Material<>();
    public static final Material<Block> PINK_WALL_BANNER = new Material<>();
    public static final Material<Block> PINK_WOOL = new Material<>();
    public static final Material<Block> PISTON = new Material<>();
    public static final Material<Block> PISTON_HEAD = new Material<>();
    public static final Material<Block> PLAYER_HEAD = new Material<>();
    public static final Material<Block> PLAYER_WALL_HEAD = new Material<>();
    public static final Material<Block> PODZOL = new Material<>();
    public static final Material<Block> POISONOUS_POTATO = new Material<>();
    public static final Material<Block> POLAR_BEAR_SPAWN_EGG = new Material<>();
    public static final Material<Block> POLISHED_ANDESITE = new Material<>();
    public static final Material<Block> POLISHED_DIORITE = new Material<>();
    public static final Material<Block> POLISHED_GRANITE = new Material<>();
    public static final Material<Block> POPPED_CHORUS_FRUIT = new Material<>();
    public static final Material<Block> POPPY = new Material<>();
    public static final Material<Block> PORKCHOP = new Material<>();
    public static final Material<Block> POTATO = new Material<>();
    public static final Material<Block> POTATOES = new Material<>();
    public static final Material<Block> POTION = new Material<>();
    public static final Material<Block> POTTED_ACACIA_SAPLING = new Material<>();
    public static final Material<Block> POTTED_ALLIUM = new Material<>();
    public static final Material<Block> POTTED_AZURE_BLUET = new Material<>();
    public static final Material<Block> POTTED_BIRCH_SAPLING = new Material<>();
    public static final Material<Block> POTTED_BLUE_ORCHID = new Material<>();
    public static final Material<Block> POTTED_BROWN_MUSHROOM = new Material<>();
    public static final Material<Block> POTTED_CACTUS = new Material<>();
    public static final Material<Block> POTTED_DANDELION = new Material<>();
    public static final Material<Block> POTTED_DARK_OAK_SAPLING = new Material<>();
    public static final Material<Block> POTTED_DEAD_BUSH = new Material<>();
    public static final Material<Block> POTTED_FERN = new Material<>();
    public static final Material<Block> POTTED_JUNGLE_SAPLING = new Material<>();
    public static final Material<Block> POTTED_OAK_SAPLING = new Material<>();
    public static final Material<Block> POTTED_ORANGE_TULIP = new Material<>();
    public static final Material<Block> POTTED_OXEYE_DAISY = new Material<>();
    public static final Material<Block> POTTED_PINK_TULIP = new Material<>();
    public static final Material<Block> POTTED_POPPY = new Material<>();
    public static final Material<Block> POTTED_RED_MUSHROOM = new Material<>();
    public static final Material<Block> POTTED_RED_TULIP = new Material<>();
    public static final Material<Block> POTTED_SPRUCE_SAPLING = new Material<>();
    public static final Material<Block> POTTED_WHITE_TULIP = new Material<>();
    public static final Material<Block> POWERED_RAIL = new Material<>();
    public static final Material<Block> PRISMARINE = new Material<>();
    public static final Material<Block> PRISMARINE_BRICKS = new Material<>();
    public static final Material<Block> PRISMARINE_BRICK_SLAB = new Material<>();
    public static final Material<Block> PRISMARINE_BRICK_STAIRS = new Material<>();
    public static final Material<Block> PRISMARINE_CRYSTALS = new Material<>();
    public static final Material<Block> PRISMARINE_SHARD = new Material<>();
    public static final Material<Block> PRISMARINE_SLAB = new Material<>();
    public static final Material<Block> PRISMARINE_STAIRS = new Material<>();
    public static final Material<Block> PUFFERFISH = new Material<>();
    public static final Material<Block> PUFFERFISH_BUCKET = new Material<>();
    public static final Material<Block> PUFFERFISH_SPAWN_EGG = new Material<>();
    public static final Material<Block> PUMPKIN = new Material<>();
    public static final Material<Block> PUMPKIN_PIE = new Material<>();
    public static final Material<Block> PUMPKIN_SEEDS = new Material<>();
    public static final Material<Block> PUMPKIN_STEM = new Material<>();
    public static final Material<Block> PURPLE_BANNER = new Material<>();
    public static final Material<Block> PURPLE_BED = new Material<>();
    public static final Material<Block> PURPLE_CARPET = new Material<>();
    public static final Material<Block> PURPLE_CONCRETE = new Material<>();
    public static final Material<Block> PURPLE_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> PURPLE_DYE = new Material<>();
    public static final Material<Block> PURPLE_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> PURPLE_SHULKER_BOX = new Material<>();
    public static final Material<Block> PURPLE_STAINED_GLASS = new Material<>();
    public static final Material<Block> PURPLE_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> PURPLE_TERRACOTTA = new Material<>();
    public static final Material<Block> PURPLE_WALL_BANNER = new Material<>();
    public static final Material<Block> PURPLE_WOOL = new Material<>();
    public static final Material<Block> PURPUR_BLOCK = new Material<>();
    public static final Material<Block> PURPUR_PILLAR = new Material<>();
    public static final Material<Block> PURPUR_SLAB = new Material<>();
    public static final Material<Block> PURPUR_STAIRS = new Material<>();
    
    
    public static final Material<Block> QUARTZ = new Material<>();
    public static final Material<Block> QUARTZ_BLOCK = new Material<>();
    public static final Material<Block> QUARTZ_PILLAR = new Material<>();
    public static final Material<Block> QUARTZ_SLAB = new Material<>();
    public static final Material<Block> QUARTZ_STAIRS = new Material<>();
    
    
    public static final Material<Block> RABBIT = new Material<>();
    public static final Material<Block> RABBIT_FOOT = new Material<>();
    public static final Material<Block> RABBIT_HIDE = new Material<>();
    public static final Material<Block> RABBIT_SPAWN_EGG = new Material<>();
    public static final Material<Block> RABBIT_STEW = new Material<>();
    public static final Material<Block> RAIL = new Material<>();
    public static final Material<Block> REDSTONE = new Material<>();
    public static final Material<Block> REDSTONE_BLOCK = new Material<>();
    public static final Material<Block> REDSTONE_LAMP = new Material<>();
    public static final Material<Block> REDSTONE_ORE = new Material<>();
    public static final Material<Block> REDSTONE_TORCH = new Material<>();
    public static final Material<Block> REDSTONE_WALL_TORCH = new Material<>();
    public static final Material<Block> REDSTONE_WIRE = new Material<>();
    public static final Material<Block> RED_BANNER = new Material<>();
    public static final Material<Block> RED_BED = new Material<>();
    public static final Material<Block> RED_CARPET = new Material<>();
    public static final Material<Block> RED_CONCRETE = new Material<>();
    public static final Material<Block> RED_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> RED_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> RED_MUSHROOM = new Material<>();
    public static final Material<Block> RED_MUSHROOM_BLOCK = new Material<>();
    public static final Material<Block> RED_NETHER_BRICKS = new Material<>();
    public static final Material<Block> RED_SAND = new Material<>();
    public static final Material<Block> RED_SANDSTONE = new Material<>();
    public static final Material<Block> RED_SANDSTONE_SLAB = new Material<>();
    public static final Material<Block> RED_SANDSTONE_STAIRS = new Material<>();
    public static final Material<Block> RED_SHULKER_BOX = new Material<>();
    public static final Material<Block> RED_STAINED_GLASS = new Material<>();
    public static final Material<Block> RED_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> RED_TERRACOTTA = new Material<>();
    public static final Material<Block> RED_TULIP = new Material<>();
    public static final Material<Block> RED_WALL_BANNER = new Material<>();
    public static final Material<Block> RED_WOOL = new Material<>();
    public static final Material<Block> REPEATER = new Material<>();
    public static final Material<Block> REPEATING_COMMAND_BLOCK = new Material<>();
    public static final Material<Block> ROSE_BUSH = new Material<>();
    public static final Material<Block> ROSE_RED = new Material<>();
    public static final Material<Block> ROTTEN_FLESH = new Material<>();
    
    
    public static final Material<Block> SADDLE = new Material<>();
    public static final Material<Block> SALMON = new Material<>();
    public static final Material<Block> SALMON_BUCKET = new Material<>();
    public static final Material<Block> SALMON_SPAWN_EGG = new Material<>();
    public static final Material<Block> SAND = new Material<>();
    public static final Material<Block> SANDSTONE = new Material<>();
    public static final Material<Block> SANDSTONE_SLAB = new Material<>();
    public static final Material<Block> SANDSTONE_STAIRS = new Material<>();
    public static final Material<Block> SCUTE = new Material<>();
    public static final Material<Block> SEAGRASS = new Material<>();
    public static final Material<Block> SEA_LANTERN = new Material<>();
    public static final Material<Block> SEA_PICKLE = new Material<>();
    public static final Material<Block> SHEARS = new Material<>();
    public static final Material<Block> SHEEP_SPAWN_EGG = new Material<>();
    public static final Material<Block> SHIELD = new Material<>();
    public static final Material<Block> SHULKER_BOX = new Material<>();
    public static final Material<Block> SHULKER_SHELL = new Material<>();
    public static final Material<Block> SHULKER_SPAWN_EGG = new Material<>();
    public static final Material<Block> SIGN = new Material<>();
    public static final Material<Block> SILVERFISH_SPAWN_EGG = new Material<>();
    public static final Material<Block> SKELETON_HORSE_SPAWN_EGG = new Material<>();
    public static final Material<Block> SKELETON_SKULL = new Material<>();
    public static final Material<Block> SKELETON_SPAWN_EGG = new Material<>();
    public static final Material<Block> SKELETON_WALL_SKULL = new Material<>();
    public static final Material<Block> SLIME_BALL = new Material<>();
    public static final Material<Block> SLIME_BLOCK = new Material<>();
    public static final Material<Block> SLIME_SPAWN_EGG = new Material<>();
    public static final Material<Block> SMOOTH_QUARTZ = new Material<>();
    public static final Material<Block> SMOOTH_RED_SANDSTONE = new Material<>();
    public static final Material<Block> SMOOTH_SANDSTONE = new Material<>();
    public static final Material<Block> SMOOTH_STONE = new Material<>();
    public static final Material<Block> SNOW = new Material<>();
    public static final Material<Block> SNOWBALL = new Material<>();
    public static final Material<Block> SNOW_BLOCK = new Material<>();
    public static final Material<Block> SOUL_SAND = new Material<>();
    public static final Material<Block> SPAWNER = new Material<>();
    public static final Material<Block> SPECTRAL_ARROW = new Material<>();
    public static final Material<Block> SPIDER_EYE = new Material<>();
    public static final Material<Block> SPIDER_SPAWN_EGG = new Material<>();
    public static final Material<Block> SPLASH_POTION = new Material<>();
    public static final Material<Block> SPONGE = new Material<>();
    public static final Material<Block> SPRUCE_BOAT = new Material<>();
    public static final Material<Block> SPRUCE_BUTTON = new Material<>();
    public static final Material<Block> SPRUCE_DOOR = new Material<>();
    public static final Material<Block> SPRUCE_FENCE = new Material<>();
    public static final Material<Block> SPRUCE_FENCE_GATE = new Material<>();
    public static final Material<Block> SPRUCE_LEAVES = new Material<>();
    public static final Material<Block> SPRUCE_LOG = new Material<>();
    public static final Material<Block> SPRUCE_PLANKS = new Material<>();
    public static final Material<Block> SPRUCE_PRESSURE_PLATE = new Material<>();
    public static final Material<Block> SPRUCE_SAPLING = new Material<>();
    public static final Material<Block> SPRUCE_SLAB = new Material<>();
    public static final Material<Block> SPRUCE_STAIRS = new Material<>();
    public static final Material<Block> SPRUCE_TRAPDOOR = new Material<>();
    public static final Material<Block> SPRUCE_WOOD = new Material<>();
    public static final Material<Block> SQUID_SPAWN_EGG = new Material<>();
    public static final Material<Block> STICK = new Material<>();
    public static final Material<Block> STICKY_PISTON = new Material<>();
    public static final Material<Block> STONE = new Material<>();
    public static final Material<Block> STONE_AXE = new Material<>();
    public static final Material<Block> STONE_BRICKS = new Material<>();
    public static final Material<Block> STONE_BRICK_SLAB = new Material<>();
    public static final Material<Block> STONE_BRICK_STAIRS = new Material<>();
    public static final Material<Block> STONE_BUTTON = new Material<>();
    public static final Material<Block> STONE_HOE = new Material<>();
    public static final Material<Block> STONE_PICKAXE = new Material<>();
    public static final Material<Block> STONE_PRESSURE_PLATE = new Material<>();
    public static final Material<Block> STONE_SHOVEL = new Material<>();
    public static final Material<Block> STONE_SLAB = new Material<>();
    public static final Material<Block> STONE_SWORD = new Material<>();
    public static final Material<Block> STRAY_SPAWN_EGG = new Material<>();
    public static final Material<Block> STRING = new Material<>();
    public static final Material<Block> STRIPPED_ACACIA_LOG = new Material<>();
    public static final Material<Block> STRIPPED_ACACIA_WOOD = new Material<>();
    public static final Material<Block> STRIPPED_BIRCH_LOG = new Material<>();
    public static final Material<Block> STRIPPED_BIRCH_WOOD = new Material<>();
    public static final Material<Block> STRIPPED_DARK_OAK_LOG = new Material<>();
    public static final Material<Block> STRIPPED_DARK_OAK_WOOD = new Material<>();
    public static final Material<Block> STRIPPED_JUNGLE_LOG = new Material<>();
    public static final Material<Block> STRIPPED_JUNGLE_WOOD = new Material<>();
    public static final Material<Block> STRIPPED_OAK_LOG = new Material<>();
    public static final Material<Block> STRIPPED_OAK_WOOD = new Material<>();
    public static final Material<Block> STRIPPED_SPRUCE_LOG = new Material<>();
    public static final Material<Block> STRIPPED_SPRUCE_WOOD = new Material<>();
    public static final Material<Block> STRUCTURE_BLOCK = new Material<>();
    public static final Material<Block> STRUCTURE_VOID = new Material<>();
    public static final Material<Block> SUGAR = new Material<>();
    public static final Material<Block> SUGAR_CANE = new Material<>();
    public static final Material<Block> SUNFLOWER = new Material<>();
    
    
    public static final Material<Block> TALL_GRASS = new Material<>();
    public static final Material<Block> TALL_SEAGRASS = new Material<>();
    public static final Material<Block> TERRACOTTA = new Material<>();
    public static final Material<Block> TIPPED_ARROW = new Material<>();
    public static final Material<Block> TNT = new Material<>();
    public static final Material<Block> TNT_MINECART = new Material<>();
    public static final Material<Block> TORCH = new Material<>();
    public static final Material<Block> TOTEM_OF_UNDYING = new Material<>();
    public static final Material<Block> TRAPPED_CHEST = new Material<>();
    public static final Material<Block> TRIDENT = new Material<>();
    public static final Material<Block> TRIPWIRE = new Material<>();
    public static final Material<Block> TRIPWIRE_HOOK = new Material<>();
    public static final Material<Block> TROPICAL_FISH = new Material<>();
    public static final Material<Block> TROPICAL_FISH_BUCKET = new Material<>();
    public static final Material<Block> TROPICAL_FISH_SPAWN_EGG = new Material<>();
    public static final Material<Block> TUBE_CORAL = new Material<>();
    public static final Material<Block> TUBE_CORAL_BLOCK = new Material<>();
    public static final Material<Block> TUBE_CORAL_FAN = new Material<>();
    public static final Material<Block> TUBE_CORAL_WALL_FAN = new Material<>();
    public static final Material<Block> TURTLE_EGG = new Material<>();
    public static final Material<Block> TURTLE_HELMET = new Material<>();
    public static final Material<Block> TURTLE_SPAWN_EGG = new Material<>();
    
    
    public static final Material<Block> VEX_SPAWN_EGG = new Material<>();
    public static final Material<Block> VILLAGER_SPAWN_EGG = new Material<>();
    public static final Material<Block> VINDICATOR_SPAWN_EGG = new Material<>();
    public static final Material<Block> VINE = new Material<>();
    public static final Material<Block> VOID_AIR = new Material<>();
    
    
    public static final Material<Block> WALL_SIGN = new Material<>();
    public static final Material<Block> WALL_TORCH = new Material<>();
    public static final Material<Block> WATER = new Material<>();
    public static final Material<Block> WATER_BUCKET = new Material<>();
    public static final Material<Block> WET_SPONGE = new Material<>();
    public static final Material<Block> WHEAT = new Material<>();
    public static final Material<Block> WHEAT_SEEDS = new Material<>();
    public static final Material<Block> WHITE_BANNER = new Material<>();
    public static final Material<Block> WHITE_BED = new Material<>();
    public static final Material<Block> WHITE_CARPET = new Material<>();
    public static final Material<Block> WHITE_CONCRETE = new Material<>();
    public static final Material<Block> WHITE_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> WHITE_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> WHITE_SHULKER_BOX = new Material<>();
    public static final Material<Block> WHITE_STAINED_GLASS = new Material<>();
    public static final Material<Block> WHITE_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> WHITE_TERRACOTTA = new Material<>();
    public static final Material<Block> WHITE_TULIP = new Material<>();
    public static final Material<Block> WHITE_WALL_BANNER = new Material<>();
    public static final Material<Block> WHITE_WOOL = new Material<>();
    public static final Material<Block> WITCH_SPAWN_EGG = new Material<>();
    public static final Material<Block> WITHER_SKELETON_SKULL = new Material<>();
    public static final Material<Block> WITHER_SKELETON_SPAWN_EGG = new Material<>();
    public static final Material<Block> WITHER_SKELETON_WALL_SKULL = new Material<>();
    public static final Material<Block> WOLF_SPAWN_EGG = new Material<>();
    public static final Material<Block> WOODEN_AXE = new Material<>();
    public static final Material<Block> WOODEN_HOE = new Material<>();
    public static final Material<Block> WOODEN_PICKAXE = new Material<>();
    public static final Material<Block> WOODEN_SHOVEL = new Material<>();
    public static final Material<Block> WOODEN_SWORD = new Material<>();
    public static final Material<Block> WRITABLE_BOOK = new Material<>();
    public static final Material<Block> WRITTEN_BOOK = new Material<>();
    
    
    public static final Material<Block> YELLOW_BANNER = new Material<>();
    public static final Material<Block> YELLOW_BED = new Material<>();
    public static final Material<Block> YELLOW_CARPET = new Material<>();
    public static final Material<Block> YELLOW_CONCRETE = new Material<>();
    public static final Material<Block> YELLOW_CONCRETE_POWDER = new Material<>();
    public static final Material<Block> YELLOW_GLAZED_TERRACOTTA = new Material<>();
    public static final Material<Block> YELLOW_SHULKER_BOX = new Material<>();
    public static final Material<Block> YELLOW_STAINED_GLASS = new Material<>();
    public static final Material<Block> YELLOW_STAINED_GLASS_PANE = new Material<>();
    public static final Material<Block> YELLOW_TERRACOTTA = new Material<>();
    public static final Material<Block> YELLOW_WALL_BANNER = new Material<>();
    public static final Material<Block> YELLOW_WOOL = new Material<>();
    
    
    public static final Material<Block> ZOMBIE_HEAD = new Material<>();
    public static final Material<Block> ZOMBIE_HORSE_SPAWN_EGG = new Material<>();
    public static final Material<Block> ZOMBIE_PIGMAN_SPAWN_EGG = new Material<>();
    public static final Material<Block> ZOMBIE_SPAWN_EGG = new Material<>();
    public static final Material<Block> ZOMBIE_VILLAGER_SPAWN_EGG = new Material<>();
    public static final Material<Block> ZOMBIE_WALL_HEAD = new Material<>();
    */
    
    static {
        for (Field f : Material.class.getFields()) {
            if (MaterialBridge.isPretechnical() && f.isAnnotationPresent(v113.class)) continue;
            if (!f.getType().equals(Material.class)) continue;
            for (Material<?> mat : MATERIAL_PRE_MAP) {
                try {
                    if (f.get(null).equals(mat)) {
                        if (f.isAnnotationPresent(v113.class)) mat.version = Version.TECHNICAL;
                        else mat.version = Version.PRETECHNICAL;
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
    
    private Version version;
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
     * Returns the version this material can be accessed.
     * @return The version this material was added. (1.12 and down are all "PRETECHNICAL")
     */
    public Version getVersion() {
        return version;
    }
    
    /**
     * Gets whether this material is compatible with the current server version
     * @return True if its compatible with the current version. False otherwise.
     */
    public boolean isCompatible() {
        return MaterialBridge.getVersion().getVersionNumber() >= getVersion().getVersionNumber();
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
            if (type.isAssignableFrom(StackedBlock.class) || type.isAssignableFrom(Item.class) || type.isAssignableFrom(Block.class)) {
                return type.getConstructor(Material.class).newInstance(this);
            }
    
            Class<T> cls;
            
            if (MaterialBridge.isPretechnical()) {
                if (!isCompatible()) throw new IncompatibleVersionException(this);
                cls = (Class<T>)Class.forName("com.njdaeger.mbapi.type.impl.pretechnical." + type.getSimpleName());
            } else cls = (Class<T>)Class.forName("com.njdaeger.mbapi.type.impl.technical." + type.getSimpleName());
            
            return cls.getConstructor(Material.class).newInstance(this);
        }
        catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        throw new TypeNotCreatedException(this);
    }
    
    /**
     * Gets the Bukkit {@link org.bukkit.Material} corresponding to the version.
     * @return The material to be used
     */
    public final org.bukkit.Material asBukkit() {
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
     * Attempts to get a modern material via its legacy name.
     * @param name The name of the Legacy Material
     * @return The modern Material for this legacy material.
     * @throws NullPointerException If the name specified is null
     * @throws ConstantNotFoundException If the Legacy name could not be matched to a modern constant
     */
    public static Material<?> ofLegacy(String name) {
        if (name == null) throw new NullPointerException("Name is null");
        for (Material<?> material : MATERIALS.values()) {
            if (material.getLegacyName().equals(name)) return material;
        }
        throw new ConstantNotFoundException(true, name);
    }
    
    /**
     * Attempts to get the modern material via its Legacy name
     * @param type The specific class block type of this material.
     * @param name The name of the legacy material
     * @return The modern material for this legacy material.
     * @throws NullPointerException If the name specified is null
     * @throws ConstantNotFoundException If the Legacy name could not be matched to a modern constant
     */
    public static <T extends MaterialType> Material<T> ofLegacy(Class<T> type, String name) {
        return (Material<T>)ofLegacy(name);
    }
    
    /**
     * Attempts to get the modern material via its legacy data
     * @param id The legacy numeric ID
     * @param durability The legacy data value
     * @return The modern material for this legacy material.
     * @throws ConstantNotFoundException If the legacy data could not be found
     */
    public static Material<?> fromData(int id, short durability) {
        for (Material<?> material : MATERIALS.values()) {
            if (!material.hasLegacyData()) continue;
            if (material.getLegacyData().getId() == id && material.getLegacyData().getDurability() == durability) return material;
        }
        throw new ConstantNotFoundException("A constant could not be matched to (ID:" + id + " Data:" + durability + ")");
    }
    
    /**
     * Attempts to get the modern material via its legacy data
     * @param id The legacy numeric ID
     * @return The modern material for this legacy material.
     * @throws ConstantNotFoundException If the legacy data could not be found
     */
    public static Material<?> fromData(int id) {
        for (Material<?> material : MATERIALS.values()) {
            if (!material.hasLegacyData()) continue;
            if (material.getLegacyData().getId() == id) return material;
        }
        throw new ConstantNotFoundException("A constant could not be matched to (ID:" + id + ")");
    }
    
    /**
     * Attempts to get the modern materail via its legacy data
     * @param blockType The specific class block type of this material.
     * @param id The legacy numeric ID
     * @param durability The legacy data value
     * @return The modern material for this legacy material.
     * @throws ConstantNotFoundException If the legacy data could not be found
     */
    public static <T extends MaterialType> Material<T> fromData(Class<T> blockType, int id, short durability) {
        return (Material<T>)fromData(id, durability);
    }
    
    /**
     * Attempts to get the modern materail via its legacy data
     * @param blockType The specific class block type of this material.
     * @param id The legacy numeric ID
     * @return The modern material for this legacy material.
     * @throws ConstantNotFoundException If the legacy data could not be found
     */
    public static <T extends MaterialType> Material<T> fromData(Class<T> blockType, int id) {
        return (Material<T>)fromData(id);
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
        throw new ConstantNotFoundException(false, name);
    }
    /**
     * Gets a material via its enum name.
     * @param blockType The specific class block type of this material.
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
