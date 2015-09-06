package com.InfinityRaider.elemancy.item;

import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.PlayerMagicProperty;
import com.InfinityRaider.elemancy.magic.Shape;
import com.InfinityRaider.elemancy.utility.RegisterHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

import java.util.List;

public class ItemMagicWeapon extends ItemElemancy {
    private Shape shapeNormal;
    private Shape shapeSpecial;

    private static final int MAX_META = 5;

    public ItemMagicWeapon(String name, Shape shapeNormal, Shape shapeSpecial) {
        super(name);
        this.shapeNormal = shapeNormal;
        this.shapeSpecial = shapeSpecial;
        this.setMaxStackSize(1);
    }

    private PlayerMagicProperty getPlayerMagic(EntityPlayer player) {
        IExtendedEntityProperties property = player.getExtendedProperties(PlayerMagicProperty.KEY);
        if (property == null) {
            return null;
        }
        if (!(property instanceof PlayerMagicProperty)) {
            return null;
        }
        return (PlayerMagicProperty) property;

    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        PlayerMagicProperty playerMagic = getPlayerMagic(player);
        if(playerMagic == null) {
            return stack;
        }
        NBTTagCompound tag = stack.getTagCompound();
        if (!world.isRemote) {
            if (player.isSneaking()) {
                if(shapeSpecial.isChanneled(playerMagic.getElement(), Element.values()[stack.getItemDamage()])) {
                    player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
                } else {
                    shapeSpecial.castSpell(world, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), -1);
                }
            } else {
                if(shapeNormal.isChanneled(playerMagic.getElement(), Element.values()[stack.getItemDamage()])) {
                    player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
                } else {
                    shapeNormal.castSpell(world, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), -1);
                }
            }
        } else {
            if (player.isSneaking()) {
                if(!shapeSpecial.isChanneled(playerMagic.getElement(), Element.values()[stack.getItemDamage()])) {
                    shapeSpecial.performClientSideStuff(world, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), -1);
                }
            } else {
                if(!shapeNormal.isChanneled(playerMagic.getElement(), Element.values()[stack.getItemDamage()])) {
                    shapeNormal.performClientSideStuff(world, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), -1);
                }
            }
        }
        return stack;
    }


    @Override
    public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
        PlayerMagicProperty playerMagic = getPlayerMagic(player);
        if(playerMagic == null) {
            return;
        }
        NBTTagCompound tag = stack.getTagCompound();
        if(player.isSneaking()) {
            if(shapeSpecial.isChanneled(playerMagic.getElement(), Element.values()[stack.getItemDamage()])) {
                if(player.worldObj.isRemote) {
                    shapeSpecial.performClientSideStuff(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), count);
                } else {
                    shapeSpecial.castSpell(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), count);
                }
            }
        } else {
            if(shapeNormal.isChanneled(playerMagic.getElement(), Element.values()[stack.getItemDamage()])) {
                if(player.worldObj.isRemote) {
                    shapeNormal.performClientSideStuff(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), count);
                } else {
                    shapeNormal.castSpell(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), count);
                }
            }
        }
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int count) {
        PlayerMagicProperty playerMagic = getPlayerMagic(player);
        if (playerMagic == null) {
            return;
        }
        NBTTagCompound tag = stack.getTagCompound();
        if (player.isSneaking()) {
            if (shapeSpecial.isChanneled(playerMagic.getElement(), Element.values()[stack.getItemDamage()])) {
                if (!player.worldObj.isRemote) {
                    shapeSpecial.onSpellStopChannel(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), count);
                }
            }
        } else {
            if (shapeNormal.isChanneled(playerMagic.getElement(), Element.values()[stack.getItemDamage()])) {
                if (player.worldObj.isRemote) {
                    shapeNormal.onSpellStopChannel(player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ, player, playerMagic.getElement(), playerMagic.getLevel(), Element.values()[stack.getItemDamage()], Element.getLevelFromNBT(tag), count);
                }
            }
        }
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)  {
        return false;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.none;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack) {
        return 100;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list) {
        for(int i=0;i<=MAX_META;i++) {
            list.add(new ItemStack(item, 1, i));
        }
    }
}
