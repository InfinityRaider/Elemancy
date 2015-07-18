package com.InfinityRaider.elemancy.magic.spell;

import com.InfinityRaider.elemancy.magic.DuplicateSpellException;
import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.Shape;
import com.InfinityRaider.elemancy.magic.spell.shield.*;

public abstract class SpellShield extends Spell{
    protected SpellShield(Element element1, Element element2, String name) throws DuplicateSpellException {
        super(element1, element2, Shape.SHIELD, name);
    }

    static void initSpells() throws DuplicateSpellException {
        new SpellRingOfFlames();
        //TODO: SHIELD + FIRE + WATER
        new SpellLavaWalking();
        new SpellReflect();
        new SpellFireImmunity();
        //TODO: SHIELD + FIRE + DEATH
        new SpellFrostShield();
        new SpellWaterWalking();
        new SpellWaterBreathing();
        new SpellReplicate();
        new SpellToxicSkin();
        new SpellProtection();
        new SpellXRay();
        new SpellRecall();
        new SpellSuicidePact();
        new SpellHaste();
        //TODO: SHIELD + AIR + LIFE
        new SpellInvisibility();
        new SpellHeal();
        new SpellDamageWard();
    }
}
