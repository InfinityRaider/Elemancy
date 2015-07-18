package com.InfinityRaider.elemancy.entity;

import com.InfinityRaider.elemancy.magic.spell.Spell;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public abstract class EntitySpellProjectile extends Entity {
    private EntityPlayer player;
    private Spell spell;

    public EntitySpellProjectile(World world) {
        super(world);
    }

    public EntitySpellProjectile(World world, EntityPlayer player, Spell spell) {
        super(world);
        this.player = player;
        this.spell = spell;
    }

    @Override
    protected void entityInit() {

    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tag) {

    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tag) {

    }
}
