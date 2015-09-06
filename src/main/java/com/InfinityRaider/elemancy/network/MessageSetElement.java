package com.InfinityRaider.elemancy.network;

import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.PlayerMagicProperty;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;

public class MessageSetElement extends MessageBase {
    private Entity entity;
    private Element element;

    public MessageSetElement() {}

    public MessageSetElement(Entity e, Element el) {
        this.entity = e;
        this.element = el;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        entity = readEntityFromByteBuf(buf);
        int ordinal = buf.readInt();
        element = ordinal<0?null:Element.values()[ordinal];
    }

    @Override
    public void toBytes(ByteBuf buf) {
        writeEntityToByteBuf(buf, entity);
        buf.writeInt((element==null?-1:element.ordinal()));
    }

    public static class MessageHandler implements IMessageHandler<MessageSetElement, IMessage> {
        @Override
        public IMessage onMessage(MessageSetElement message, MessageContext ctx) {
            if(message.entity==null) {
                return null;
            }
            PlayerMagicProperty prop = (PlayerMagicProperty) message.entity.getExtendedProperties(PlayerMagicProperty.KEY);
            prop.setElement(message.element);
            return null;
        }
    }
}
