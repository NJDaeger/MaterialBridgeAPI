package com.njdaeger.mbapi;

import org.bukkit.block.BlockFace;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Util {
    
    public static Set<BlockFace> mainDirections() {
        Set<BlockFace> mainDirections = new HashSet<>();
        mainDirections.add(BlockFace.NORTH);
        mainDirections.add(BlockFace.SOUTH);
        mainDirections.add(BlockFace.EAST);
        mainDirections.add(BlockFace.WEST);
        return mainDirections;
    }
    
    public static Set<BlockFace> allDirectionsExcept(BlockFace... directions) {
        Set<BlockFace> allowed = Stream.of(BlockFace.values()).collect(Collectors.toSet());
        allowed.removeAll(Stream.of(directions).collect(Collectors.toSet()));
        return allowed;
    }
    
}
