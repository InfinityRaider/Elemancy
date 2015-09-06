package com.InfinityRaider.elemancy.magic;

import com.InfinityRaider.elemancy.network.MessageSetElement;
import com.InfinityRaider.elemancy.network.MessageSetLevel;
import com.InfinityRaider.elemancy.network.MessageSyncMagicProperty;
import com.InfinityRaider.elemancy.network.NetworkWrapperElemancy;
import com.InfinityRaider.elemancy.reference.Constants;
import com.InfinityRaider.elemancy.reference.Names;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerMagicProperty implements IExtendedEntityProperties {
    public static final String KEY = Names.NBT.MAGIC_CAPABILITIES;
    private Entity entity;

    private Element element;
    private int level;

    @SideOnly(Side.SERVER)
    private boolean needsSync;

    public PlayerMagicProperty(Entity entity) {
        this.entity = entity;
    }

    public Element getElement() {
        return element;
    }

    public int getLevel() {
        return level;
    }

    public void setElement(Element e) {
        if(e != element) {
            if(entity.worldObj.isRemote) {
                NetworkWrapperElemancy.wrapper.sendToServer(new MessageSetElement(entity, e));
            } else {
                this.element = e;
                needsSync = true;
            }
        }
    }

    public void setLevel(int lvl) {
        lvl = checkLevel(lvl);
        if(lvl != level) {
            if(entity.worldObj.isRemote) {
                NetworkWrapperElemancy.wrapper.sendToServer(new MessageSetLevel(entity, lvl));
            } else {
                this.level = lvl;
                needsSync = true;
            }
        }
    }

    @Override
    public void saveNBTData(NBTTagCompound tag) {
        tag.setInteger(Names.NBT.LEVEL, level);
        if(element != null) {
            tag.setInteger(Names.NBT.ELEMENT, element.ordinal());
        }
    }

    @Override
    public void loadNBTData(NBTTagCompound tag) {
        this.level = tag.hasKey(Names.NBT.LEVEL)?tag.getInteger(Names.NBT.LEVEL):0;
        this.element = tag.hasKey(Names.NBT.ELEMENT)?Element.values()[tag.getInteger(Names.NBT.ELEMENT)]:null;
    }

    @Override
    public void init(Entity entity, World world) {
        if(world==null || entity==null) {
            return;
        }
        element = null;
        level = 0;
        this.needsSync = true;
    }

    @SideOnly(Side.SERVER)
    private void syncToClient() {
        if(needsSync) {
            if(!entity.worldObj.isRemote) {
                NetworkWrapperElemancy.wrapper.sendToAllAround(new MessageSyncMagicProperty(entity, element, level), new NetworkRegistry.TargetPoint(entity.dimension, entity.posX, entity.posY, entity.posZ, 32));
                needsSync = false;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public static void syncData(Entity entity, Element e, int lvl) {
        lvl = checkLevel(lvl);
        PlayerMagicProperty prop = (PlayerMagicProperty) entity.getExtendedProperties(KEY);
        if(prop.entity != entity) {
            return;
        }
        prop.element = e;
        prop.level = lvl;
    }

    private static int checkLevel(int lvl) {
        return lvl>Constants.MAX_MAGIC_LVL?Constants.MAX_MAGIC_LVL:lvl;
    }
}
