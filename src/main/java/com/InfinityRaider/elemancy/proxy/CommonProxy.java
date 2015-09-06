package com.InfinityRaider.elemancy.proxy;

import net.minecraft.entity.Entity;

public abstract class CommonProxy implements IProxy {
    @Override
    public void registerEventHandlers() {

    }

    @Override
    public Entity getEntityById(int dimension, int id) {
        return getEntityById(getWorldByDimensionId(dimension), id);
    }
}
