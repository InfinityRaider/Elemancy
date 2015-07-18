package com.InfinityRaider.elemancy.creativetab;

import com.InfinityRaider.elemancy.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabElemency extends CreativeTabs{
    public static final CreativeTabs TAB = new CreativeTabElemency();

    private CreativeTabElemency() {
        super(Reference.MOD_ID.toLowerCase());
    }

    @Override
    public Item getTabIconItem() {
        return null;
    }
}
