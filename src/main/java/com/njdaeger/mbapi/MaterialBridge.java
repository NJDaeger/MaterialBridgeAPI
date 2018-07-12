package com.njdaeger.mbapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

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
    
        System.out.println(Arrays.toString(Material.values()));
        
        Bukkit.getServicesManager().register(MaterialBridge.class, this, this, ServicePriority.High);
    }
    
    @Override
    public void onDisable() {
        super.onDisable();
    }
    
    public static Version getVersion() {
        return version;
    }
    
}
