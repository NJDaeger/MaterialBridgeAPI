package com.njdaeger.mbapi;

import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Test extends BukkitCommand {
    
    public Test() {
        super("test");
        setUsage("/test");
        setDescription("Test the material api and the command framework");
    }
    
    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        Player player = (Player)sender;
        Set<com.njdaeger.mbapi.Material> transparent = new HashSet<>();
        transparent.add(Material.AIR);
        Location location = player.getTargetBlock(transparent.stream().map(Material::getBukkitMaterial).collect(Collectors.toSet()), 30).getLocation();
        Material.ACACIA_STAIRS.get().setBlock(location);
        return true;
    }
}
