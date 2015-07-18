package com.InfinityRaider.elemancy.network;

import com.InfinityRaider.elemancy.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class NetworkWrapperElemancy {
    public static SimpleNetworkWrapper wrapper;

    public static void init() {
        wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());
        initMessages();
    }

    private static void initMessages() {

    }
}
