package com.InfinityRaider.elemancy.network;

import com.InfinityRaider.elemancy.magic.PlayerMagicProperty;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;

public class MessageSetLevel extends MessageBase {
    private Entity entity;
    private int level;

    public MessageSetLevel() {}

    public MessageSetLevel(Entity e, int lvl) {
        this.entity = e;
        this.level = lvl;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        entity = readEntityFromByteBuf(buf);
        level = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        writeEntityToByteBuf(buf, entity);
        buf.writeInt(level);
    }

    public static class MessageHandler implements IMessageHandler<MessageSetLevel, IMessage> {
        @Override
        public IMessage onMessage(MessageSetLevel message, MessageContext ctx) {
            if(message.entity==null) {
                return null;
            }
            PlayerMagicProperty prop = (PlayerMagicProperty) message.entity.getExtendedProperties(PlayerMagicProperty.KEY);
            prop.setLevel(message.level);
            return null;
        }
    }
}
