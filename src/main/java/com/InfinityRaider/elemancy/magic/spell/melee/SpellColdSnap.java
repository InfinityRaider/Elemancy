package com.InfinityRaider.elemancy.magic.spell.melee;

import com.InfinityRaider.elemancy.magic.DuplicateSpellException;
import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.spell.SpellMelee;
import com.InfinityRaider.elemancy.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public final class SpellColdSnap extends SpellMelee {
    public SpellColdSnap() throws DuplicateSpellException {
        super(Element.WATER, Element.WATER, Names.Spells.COLD_SNAP);
    }

    @Override
    public boolean isChanneled() {
        return false;
    }

    @Override
    public void castSpell(World world, int x, int y, int z, EntityPlayer player, int lvl1, int lvl2, int channelTicks) {

    }

    @Override
    public void onStopChannel(World world, int x, int y, int z, EntityPlayer player, int lvl1, int lvl2, int channelTicks) {

    }

    @Override
    public void spellParticles(World world, int x, int y, int z, EntityPlayer player, int lvl1, int lvl2, int channelTicks) {

    }
}
