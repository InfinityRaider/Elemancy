package com.InfinityRaider.elemancy.item;

import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.MagicHandler;
import com.InfinityRaider.elemancy.reference.Constants;
import com.InfinityRaider.elemancy.utility.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDebugger extends ItemElemancy {
    public ItemDebugger() {
        super("debugger");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            if (player.isSneaking()) {
                Element e = MagicHandler.getMagicElement(player);
                int ordinal = e==null?0:e.ordinal()+1;
                e = Element.getElement(ordinal);
                LogHelper.debug("setting element of player " + player.getDisplayName() + " to " + e.name());
                MagicHandler.setMagicElement(player, e);
            } else {
                if(MagicHandler.getMagicLevel(player)== Constants.MAX_MAGIC_LVL) {
                    MagicHandler.resetMagicLevel(player);
                } else {
                    MagicHandler.increaseMagicLevel(player);
                }
            }
        }
        return false;
    }
}
