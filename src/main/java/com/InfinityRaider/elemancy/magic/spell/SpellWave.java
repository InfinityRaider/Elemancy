package com.InfinityRaider.elemancy.magic.spell;

import com.InfinityRaider.elemancy.magic.DuplicateSpellException;
import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.Shape;
import com.InfinityRaider.elemancy.magic.spell.wave.*;

public abstract  class SpellWave extends Spell {
    protected SpellWave(Element element1, Element element2, String name)  throws DuplicateSpellException {
        super(element1, element2, Shape.WAVE, name);
    }

    static void initSpells() throws DuplicateSpellException {
        new SpellFlameThrower();
        new SpellBlind();
        //TODO: WAVE + FIRE + EARTH
        new SpellHeatWave();
        //TODO: WAVE + FIRE + LIFE
        new SpellCursedFlames();
        new SpellTsunami();
        new SpellFreeze();
        new SpellTornado();
        //TODO: WAVE + WATER + LIFE
        new SpellStarve();
        new SpellErectWall();
        new SpellCrystalStorm();
        //TODO: WAVE + EARTH + LIFE
        //TODO: WAVE + EARTh + DEATH
        new SpellPropel();
        new SpellBeeSwarm();
        //TODO: WAVE + AIR + DEATH
        //TODO: WAVE + LIFE + LIFE
        //TODO: WAVE + LIFE + DEATH
        new SpellHarvestSoul();
    }
}
