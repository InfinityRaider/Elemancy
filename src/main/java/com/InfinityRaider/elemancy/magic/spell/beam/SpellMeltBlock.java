package com.InfinityRaider.elemancy.magic.spell.beam;

import com.InfinityRaider.elemancy.magic.DuplicateSpellException;
import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.spell.SpellBeam;
import com.InfinityRaider.elemancy.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public final class SpellMeltBlock extends SpellBeam {
    public SpellMeltBlock() throws DuplicateSpellException {
        super(Element.FIRE, Element.EARTH, Names.Spells.MELT_BLOCK);
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
