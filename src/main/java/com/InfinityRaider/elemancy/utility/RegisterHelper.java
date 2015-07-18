package com.InfinityRaider.elemancy.utility;

import com.InfinityRaider.elemancy.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class RegisterHelper {
    public static void registerBlock(Block block,String name, Class<? extends ItemBlock> itemClass) {
        block.setBlockName(Reference.MOD_ID.toLowerCase()+':'+name);
        LogHelper.info("registering " + block.getUnlocalizedName());
        if(itemClass!=null) {
            GameRegistry.registerBlock(block, itemClass, name);
        }
        else {
            GameRegistry.registerBlock(block, name);
        }
    }

    public static void registerItem(Item item,String name) {
        item.setUnlocalizedName(Reference.MOD_ID.toLowerCase()+':'+name);
        LogHelper.info("registering " + item.getUnlocalizedName());
        GameRegistry.registerItem(item, name);
    }
}
