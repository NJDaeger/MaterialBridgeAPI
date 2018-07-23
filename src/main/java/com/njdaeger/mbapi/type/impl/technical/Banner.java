package com.njdaeger.mbapi.type.impl.technical;

import com.njdaeger.mbapi.Material;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.BlockState;

public final class Banner extends com.njdaeger.mbapi.type.specific.Banner {
    
    public Banner(Material<com.njdaeger.mbapi.type.specific.Banner> material) {
        super(material);
    }
    
    @Override
    public void setBlock(Location location, boolean setIfDifferent, boolean applyPhysics) {
        if (isValid(location, setIfDifferent, applyPhysics)) {
            Block block = location.getBlock();
            BlockState state = block.getState();
            System.out.println(state.getBlockData());
            System.out.println(BlockFace.valueOf(getDirection().name()));
            org.bukkit.block.Banner bannerPatterns = (org.bukkit.block.Banner)state;
            bannerPatterns.setPatterns(getPatterns());
            org.bukkit.material.Banner data = (org.bukkit.material.Banner)block.getState().getData();
            data.setFacingDirection(BlockFace.valueOf(getDirection().name()));
            bannerPatterns.setData(data);
            bannerPatterns.update(true, applyPhysics);
        }
    }
}
