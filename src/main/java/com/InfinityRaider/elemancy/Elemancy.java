package com.InfinityRaider.elemancy;

import com.InfinityRaider.elemancy.handler.ConfigurationHandler;
import com.InfinityRaider.elemancy.init.Blocks;
import com.InfinityRaider.elemancy.init.Entities;
import com.InfinityRaider.elemancy.init.Items;
import com.InfinityRaider.elemancy.magic.spell.Spell;
import com.InfinityRaider.elemancy.network.NetworkWrapperElemancy;
import com.InfinityRaider.elemancy.proxy.IProxy;
import com.InfinityRaider.elemancy.reference.Reference;
import com.InfinityRaider.elemancy.utility.LogHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class Elemancy {
    @Mod.Instance(Reference.MOD_ID)
    public static Elemancy instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        LogHelper.debug("Starting Pre-Initialization");
        proxy.registerEventHandlers();
        NetworkWrapperElemancy.init();
        ConfigurationHandler.init(event);
        Blocks.init();
        Items.init();
        LogHelper.debug("Pre-Initialization Complete");
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event) {
        LogHelper.debug("Starting Initialization");
        Entities.init();
        proxy.registerRenderers();
        proxy.registerKeyBindings();
        LogHelper.debug("Initialization Complete");
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event) {
        LogHelper.debug("Starting Post-Initialization");
        Spell.init();
        LogHelper.debug("Post-Initialization Complete");
    }

    @Mod.EventHandler
    public static void onServerStart(FMLServerStartingEvent event) {

    }


}
