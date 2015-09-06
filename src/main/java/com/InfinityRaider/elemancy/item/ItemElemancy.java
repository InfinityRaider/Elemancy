package com.InfinityRaider.elemancy.item;

import com.InfinityRaider.elemancy.creativetab.CreativeTabElemency;
import com.InfinityRaider.elemancy.utility.LogHelper;
import com.InfinityRaider.elemancy.utility.RegisterHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public abstract  class ItemElemancy extends Item {
    public ItemElemancy(String name) {
        super();
        this.setCreativeTab(CreativeTabElemency.TAB);
        RegisterHelper.registerItem(this, name);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        LogHelper.debug("registering icon for: " + this.getUnlocalizedName());
        itemIcon = reg.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.')+1));
    }
}
