package com.InfinityRaider.elemancy.network;

import com.InfinityRaider.elemancy.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class NetworkWrapperElemancy {
    public static SimpleNetworkWrapper wrapper;

    public static final int SYNC_MAGIC_PROPERTY_ID = 0;
    public static final int SET_ELEMENT_ID = 1;
    public static final int SET_LEVEL_ID = 2;

    public static void init() {
        wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());
        initMessages();
    }

    private static void initMessages() {
        wrapper.registerMessage(MessageSyncMagicProperty.MessageHandler.class, MessageSyncMagicProperty.class, SYNC_MAGIC_PROPERTY_ID, Side.CLIENT);
        wrapper.registerMessage(MessageSetElement.MessageHandler.class, MessageSetElement.class, SET_ELEMENT_ID, Side.SERVER);
        wrapper.registerMessage(MessageSetLevel.MessageHandler.class, MessageSetLevel.class, SET_LEVEL_ID, Side.SERVER);
    }
}
