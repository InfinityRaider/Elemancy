package com.InfinityRaider.elemancy.magic;

import com.InfinityRaider.elemancy.reference.Names;
import net.minecraft.nbt.NBTTagCompound;

public enum Element {
    FIRE,
    WATER(FIRE),
    EARTH,
    AIR(EARTH),
    LIFE,
    DEATH(LIFE);

    Element() {}

    private Element opposite;

    Element(Element opposite) {
        this.opposite = opposite;
        opposite.opposite = this;
    }

    public boolean isOpposite(Element element) {
        return this.opposite == element;
    }

    public Element getOpposite() {
        return this.opposite;
    }

    public double modifier(Element element) {
        if(this == element) {
            return 0.5D;
        }
        if(this.isOpposite(element)) {
            return 2.0D;
        }
        return 1.0D;
    }

    public static int getLevelFromNBT(NBTTagCompound tag) {
        if(!isValidTag(tag)) {
            return -1;
        }
        return tag.getInteger(Names.NBT.LEVEL);
    }

    private static boolean isValidTag(NBTTagCompound tag) {
        return (tag != null) && (tag.hasKey(Names.NBT.ELEMENT)) && (tag.hasKey(Names.NBT.LEVEL));
    }

}
