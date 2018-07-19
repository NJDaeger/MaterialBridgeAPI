package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.type.TrapDoor;

public class Trapdoor extends com.njdaeger.mbapi.type.specific.Trapdoor {
    
    public Trapdoor(Material<com.njdaeger.mbapi.type.specific.Trapdoor> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            TrapDoor trapDoor = (TrapDoor)block.getBlockData();
            trapDoor.setFacing(BlockFace.valueOf(getDirection().name()));
            trapDoor.setHalf(Bisected.Half.valueOf(getHalf().name()));
            trapDoor.setWaterlogged(isWaterlogged());
            trapDoor.setPowered(isPowered());
            trapDoor.setOpen(isOpen());
            block.setBlockData(trapDoor, applyPhysics);
        }
    }
}
