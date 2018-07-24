package com.njdaeger.mbapi.properties;

import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.data.MaterialType;
import org.bukkit.inventory.ItemStack;

public interface Stackable<T extends MaterialType> extends Property<T> {
    
    default ItemStack toItemStack() {
        return toItemStack(getMaterial().getMaxStackSize());
    }
    
    default ItemStack toItemStack(int size) {
        if (size < 0) size = 1;
        if (size > getMaterial().getMaxStackSize()) size = getMaterial().getMaxStackSize();
        if (getMaterial().asBukkit() == null) return null; //This should only be null when the material is from a TECHNICAL+ version and the current version is PRETECHNICAL
        if (MaterialBridge.isPretechnical()) {
            ItemStack stack = new ItemStack(getMaterial().asBukkit(), size);
            stack.setDurability(getMaterial().getLegacyData().getDurability());
            return stack;
        }
        else return new ItemStack(getMaterial().asBukkit(), size);
    }
    
}
