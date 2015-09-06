package com.InfinityRaider.elemancy.proxy;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public interface IProxy {
    void registerEventHandlers();

    void registerRenderers();

    void registerKeyBindings();

    World getClientWorld();

    World getWorldByDimensionId(int dimension);

    Entity getEntityById(int id);

    Entity getEntityById(int dimension, int id);

    Entity getEntityById(World world, int id);
}
