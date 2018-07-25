package com.njdaeger.mbapi;

import com.njdaeger.mbapi.properties.data.Direction;
import org.bukkit.block.Block;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Util {
    
    private static Method setData = null;
    
    public static Set<Direction> mainDirections() {
        Set<Direction> mainDirections = new HashSet<>();
        mainDirections.add(Direction.NORTH);
        mainDirections.add(Direction.SOUTH);
        mainDirections.add(Direction.EAST);
        mainDirections.add(Direction.WEST);
        return mainDirections;
    }
    
    public static Set<Direction> allDirectionsExcept(Direction... directions) {
        Set<Direction> allowed = Stream.of(Direction.values()).collect(Collectors.toSet());
        allowed.removeAll(Stream.of(directions).collect(Collectors.toSet()));
        return allowed;
    }
    
    /**
     * @deprecated Only to be used for PreTechnical worlds.
     */
    @Deprecated
    public static void setData(Block block, short data, boolean applyPhysics) {
        if (MaterialBridge.isPretechnical()) {
            if (setData == null) {
                try {
                    Util.setData = block.getClass().getMethod("setData", byte.class, boolean.class);
                }
                catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
            try {
                setData.invoke(block, Byte.valueOf(Short.toString(data)), applyPhysics);
            }
            catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        else throw new UnsupportedOperationException("Legacy data cannot be set on 1.13.x + servers. Please use the BlockData API provided by Bukkit.");
    }
    
}
