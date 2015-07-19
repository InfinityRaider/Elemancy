package com.InfinityRaider.elemancy.handler;

import com.InfinityRaider.elemancy.utility.LogHelper;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

public class ConfigurationHandler {
    public static final String CATEGORY_DEBUG = "debug";

    public static Configuration config;

    //debug
    public static boolean debug;

    public static void init(FMLPreInitializationEvent event) {
        if(config == null) {
            config = new Configuration(event.getSuggestedConfigurationFile());
            loadConfiguration();
        }
        LogHelper.debug("Configuration Loaded");
    }

    private static void loadConfiguration() {
        //debug mode
        debug = config.getBoolean("debug",CATEGORY_DEBUG,false,"Set to true if you wish to enable debug mode");

        if(config.hasChanged()) {config.save();}
    }
}
