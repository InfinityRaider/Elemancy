package com.InfinityRaider.elemancy.magic;

import com.InfinityRaider.elemancy.reference.Names;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerMagicProperty implements IExtendedEntityProperties {
    public static final String KEY = Names.NBT.MAGIC_CAPABILITIES;

    private Element element;
    private int level;

    public Element getElement() {
        return element;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void saveNBTData(NBTTagCompound tag) {
        tag.setInteger(Names.NBT.LEVEL, level);
        tag.setInteger(Names.NBT.ELEMENT, element.ordinal());
    }

    @Override
    public void loadNBTData(NBTTagCompound tag) {
        this.level = tag.getInteger(Names.NBT.LEVEL);
        this.element = Element.values()[tag.getInteger(Names.NBT.ELEMENT)];
    }

    @Override
    public void init(Entity entity, World world) {

    }
}
