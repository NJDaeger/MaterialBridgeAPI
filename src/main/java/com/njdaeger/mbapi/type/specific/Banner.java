package com.njdaeger.mbapi.type.specific;

import com.njdaeger.mbapi.Material;
import com.njdaeger.mbapi.Util;
import com.njdaeger.mbapi.data.StackedBlockType;
import com.njdaeger.mbapi.properties.Directional;
import com.njdaeger.mbapi.properties.data.Direction;
import org.bukkit.DyeColor;
import org.bukkit.block.banner.Pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public abstract class Banner extends StackedBlockType<Banner> implements Directional<Banner> {
    
    private Set<Direction> allowedDirections;
    private List<Pattern> patterns;
    private Direction direction;
    private DyeColor color;//TODO dyecolor somehow
    
    public Banner(Material<Banner> material) {
        super(material);
        this.allowedDirections = Util.allDirectionsExcept(Direction.UP, Direction.DOWN, Direction.SELF);
        this.patterns = new ArrayList<>();
        this.color = DyeColor.WHITE;
    }
    
    @Override
    public void setDirection(Direction direction) {
        if (isAllowedDirection(direction)) this.direction = direction;
    }
    
    @Override
    public Direction getDirection() {
        return direction;
    }
    
    @Override
    public Set<Direction> getAllowedDirections() {
        return Collections.unmodifiableSet(allowedDirections);
    }
    
    public void addPattern(Pattern pattern) {
        patterns.add(pattern);
    }
    
    public void removePattern(int patternIndex) {
        patterns.remove(patternIndex);
    }
    
    public List<Pattern> getPatterns() {
        return patterns;
    }
    
    public int getPatternAmount() {
        return patterns.size();
    }
    
    public DyeColor getColor() {
        throw new UnsupportedOperationException("Waiting for full 1.13 release.");
    }
    
}
