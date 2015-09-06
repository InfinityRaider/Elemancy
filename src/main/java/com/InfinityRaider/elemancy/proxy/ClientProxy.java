package com.InfinityRaider.elemancy.proxy;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerEventHandlers() {
        super.registerEventHandlers();
    }

    @Override
    public void registerRenderers() {

    }

    @Override
    public void registerKeyBindings() {

    }

    @Override
    public World getClientWorld() {
        return Minecraft.getMinecraft().theWorld;
    }

    @Override
    public World getWorldByDimensionId(int id) {
        return FMLClientHandler.instance().getServer().worldServerForDimension(id);
    }

    @Override
    public Entity getEntityById(int id) {
        return getEntityById(getClientWorld(), id);
    }

    @Override
    public Entity getEntityById(World world, int id) {
        return world.getEntityByID(id);
    }
}
