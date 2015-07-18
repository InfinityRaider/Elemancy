package com.InfinityRaider.elemancy.magic.spell;

import com.InfinityRaider.elemancy.magic.DuplicateSpellException;
import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.Shape;
import com.InfinityRaider.elemancy.magic.spell.zone.*;

public abstract class SpellZone extends Spell {
    protected SpellZone(Element element1, Element element2, String name) throws DuplicateSpellException {
        super(element1, element2, Shape.ZONE, name);
    }

    static void initSpells() throws DuplicateSpellException {
        new SpellSunstrike();
        new SpellMist();
        //TODO: ZONE + FIRE + EARTH
        new SpellInferno();
        //TODO: ZONE + FIRE + LIFE
        //TODO: ZONE + FIRE + DEATH
        new SpellIceWall();
        //TODO: ZONE + WATER + EARTH
        new SpellToggleRain();
        new SpellBonemealing();
        new SpellPoisonNova();
        new SpellSplitEarth();
        new SpellLiftTerrain();
        new SpellSproutFlora();
        new SpellKillFlora();
        new SpellEmp();
        //TODO: ZONE + AIR + LIFE
        new SpellVacuum();
        new SpellDispell();
        new SpellNecromancy();
    }
}
