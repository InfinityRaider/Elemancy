package com.InfinityRaider.elemancy.proxy;

import cpw.mods.fml.server.FMLServerHandler;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class ServerProxy extends CommonProxy {
    @Override
    public void registerRenderers() {
        //NO OP
    }

    @Override
    public void registerKeyBindings() {
        //NO OP
    }

    @Override
    public World getClientWorld() {
        return null;
    }

    @Override
    public World getWorldByDimensionId(int dimension) {
        return FMLServerHandler.instance().getServer().worldServerForDimension(dimension);
    }

    @Override
    public Entity getEntityById(int id) {
        Entity e = null;
        for(WorldServer world: FMLServerHandler.instance().getServer().worldServers) {
            e = getEntityById(world, id);
            if(e != null) {
                break;
            }
        }
        return e;
    }

    @Override
    public Entity getEntityById(World world, int id) {
        return world.getEntityByID(id);
    }
}
