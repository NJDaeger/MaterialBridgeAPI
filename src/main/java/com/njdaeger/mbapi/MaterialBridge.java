package com.njdaeger.mbapi;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Level;

public class MaterialBridge extends JavaPlugin {
    
    private static Version version;
    
    @Override
    public void onEnable() {
        
        String found = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3].replaceAll("_R\\d", "").replace("_", "").replaceAll("\\D", "");
        int parsed = Integer.parseInt(found);
        version = Version.getVersionByNumber(parsed);
    
        getLogger().log(Level.INFO, "MBAPI Support Version: " + version.name() + " (" + version.getSupport() + ")");
        //System.out.println(Material.ACACIA_BUTTON.get().isPowered());
        
        
        try {
        
            Field field = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            field.setAccessible(true);
            ((CommandMap)field.get(Bukkit.getServer())).register("mbapi", new Test());
        }
    
        catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        
        System.out.println(Arrays.toString(Material.values()));
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
    }
    
    public static Version getVersion() {
        return version;
    }
    
    public static boolean isPretechnical() {
        return version == Version.PRETECHNICAL;
    }
    
}
