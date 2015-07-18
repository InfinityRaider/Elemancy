package com.InfinityRaider.elemancy.magic.spell;

import com.InfinityRaider.elemancy.magic.DuplicateSpellException;
import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.Shape;
import com.InfinityRaider.elemancy.magic.spell.melee.*;

public abstract class SpellMelee extends Spell {
    protected SpellMelee(Element element1, Element element2, String name) throws DuplicateSpellException {
        super(element1, element2, Shape.MELEE, name);
    }

    static void initSpells() throws DuplicateSpellException {
        new SpellIgnite();
        //TODO: MELEE + FIRE + WATER
        //TODO: MELEE + FIRE + EARTH
        new SpellPierceArmor();
        //TODO: MELEE + FIRE + LIFE
        new SpellBanishToNether();
        new SpellColdSnap();
        new SpellSlow();
        //TODO: MELEE + WATER + AIR
        //TODO: MELEE + WATER + LIFE
        //TODO: MELEE + WATER + DEATH
        new SpellStoning();
        //TODO: MELEE + EARTH + AIR
        new SpellEntangle();
        new SpellDecapitate();
        new SpellFling();
        //TODO: MELEE + AIR + LIFE
        new SpellHallucinations();
        new SpellCharm();
        new SpellLifeSteal();
        new SpellWither();
    }
}
