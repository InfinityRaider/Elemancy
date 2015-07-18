package com.InfinityRaider.elemancy.entity;

import com.InfinityRaider.elemancy.magic.Element;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EntityMage extends EntityLiving {
    private Element element;
    private int level;

    public EntityMage(World world) {
        super(world);
    }

    public EntityMage(World world, Element affinity, int level) {
        super(world);
        this.element = affinity;
        this.level = level;
    }
}
