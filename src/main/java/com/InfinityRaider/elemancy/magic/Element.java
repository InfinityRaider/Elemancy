package com.InfinityRaider.elemancy.magic;

import com.InfinityRaider.elemancy.reference.Names;
import net.minecraft.nbt.NBTTagCompound;

public enum Element {
    FIRE(255, 93, 0),
    WATER(0, 159, 255, FIRE),
    EARTH(116, 62, 0),
    AIR(255, 255, 0, EARTH),
    LIFE(29, 132, 0),
    DEATH(80, 0, 114, LIFE);

    int red;
    int blue;
    int green;
    private Element opposite;

    Element(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    Element(int red, int green, int blue, Element opposite) {
        this(red, green, blue);
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

    public float[] getColorModifier() {
        float[] colors = new float[3];
        colors[0] = ((float)this.red)/(255.00F);
        colors[1] = ((float)this.green)/(255.00F);
        colors[2] = ((float)this.blue)/(255.00F);
        return colors;
    }

}
