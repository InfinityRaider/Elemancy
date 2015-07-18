package com.InfinityRaider.elemancy.magic.spell;

import com.InfinityRaider.elemancy.magic.DuplicateSpellException;
import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.Shape;
import com.InfinityRaider.elemancy.magic.spell.beam.*;

public abstract class SpellBeam extends Spell {
    protected SpellBeam(Element element1, Element element2, String name) throws DuplicateSpellException {
        super(element1, element2, Shape.BEAM, name);
    }

    static void initSpells() throws DuplicateSpellException {
        new SpellFireBeam();
        new SpellEvaporateWater();
        new SpellMeltBlock();
        new SpellConjureMeteor();
        //TODO: BEAM + FIRE + LIFE
        //TODO: BEAM + FIRE + DEATH
        new SpellWaterJet();
        new SpellDrownEntity();
        //TODO: BEAM + WATER + AIR
        new SpellColdEmbrace();
        new SpellFrostBeam();
        new SpellDig();
        new SpellTelekinesis();
        new SpellConjureEnt();
        new SpellErode();
        new SpellChainLightning();
        new SpellRainbowBeam();
        new SpellForceChoke();
        new SpellHealingBeam();
        new SpellLifeSiphon();
        new SpellShadowBeam();
    }
}
