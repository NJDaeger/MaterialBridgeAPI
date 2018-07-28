package com.njdaeger.mbapi.type.impl.pretechnical;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
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
            Util.setData(location.getBlock(), getLegacyData().getDurability(), applyPhysics);
            Block block = location.getBlock();
            BlockState state = block.getState();
            org.bukkit.block.Banner bannerPatterns = (org.bukkit.block.Banner)state;
            bannerPatterns.setPatterns(getPatterns());
            org.bukkit.material.Banner data = (org.bukkit.material.Banner)state.getData();
            data.setFacingDirection(BlockFace.valueOf(getDirection().name()));
            bannerPatterns.setData(data);
            bannerPatterns.update(true, applyPhysics);
        }
    }
}
