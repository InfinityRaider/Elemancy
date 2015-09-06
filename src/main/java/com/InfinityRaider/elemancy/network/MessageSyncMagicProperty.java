package com.InfinityRaider.elemancy.network;

import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.PlayerMagicProperty;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;

public class MessageSyncMagicProperty extends MessageBase {
    private Entity entity;
    private Element element;
    private int lvl;

    public MessageSyncMagicProperty() {}

    public MessageSyncMagicProperty(Entity entity, Element e, int lvl) {
        this.entity = entity;
        this.element = e;
        this.lvl = lvl;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        entity = readEntityFromByteBuf(buf);
        int ordinal = buf.readInt();
        element = ordinal<0?null:Element.values()[ordinal];
        lvl = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        writeEntityToByteBuf(buf, entity);
        buf.writeInt((element==null?-1:element.ordinal()));
        buf.writeInt(lvl);
    }

    public static class MessageHandler implements IMessageHandler<MessageSyncMagicProperty, IMessage> {
        @Override
        public IMessage onMessage(MessageSyncMagicProperty message, MessageContext ctx) {
            if(message.entity==null) {
                return null;
            }
            PlayerMagicProperty.syncData(message.entity, message.element, message.lvl);
            return null;
        }
    }
}
