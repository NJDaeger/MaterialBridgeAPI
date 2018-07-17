package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.MaterialBridge;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Orientable;
import org.bukkit.Axis;
import org.bukkit.Location;
import org.bukkit.block.Block;

/*
Properties:

- Axis      Orientable
 */
public class Pillar extends StackedBlockType<Pillar> implements Orientable<Pillar> {
    
    private Axis axis;
    
    public Pillar(Material<Pillar> material) {
        super(material);
        this.axis = Axis.X;
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        Block block = location.getBlock();
        if (!block.getType().equals(getBukkitMaterial())) {
            if (setIfDifferent) block.setType(getBukkitMaterial());
            else return;
        }
        if (MaterialBridge.isPretechnical()) {
            block.setData((byte)getLegacyData().getDurability(), applyPhysics);
            return;
        }
        org.bukkit.block.data.Orientable pillar = (org.bukkit.block.data.Orientable)block.getBlockData();
        pillar.setAxis(axis);
        block.setBlockData(pillar);
    }
    
    @Override
    public void setAxis(Axis axis) {
        this.axis = axis;
    }
    
    @Override
    public Axis getAxis() {
        return axis;
    }
}
