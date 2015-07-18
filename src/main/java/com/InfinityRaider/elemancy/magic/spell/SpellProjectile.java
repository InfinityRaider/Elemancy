package com.InfinityRaider.elemancy.magic.spell;

import com.InfinityRaider.elemancy.magic.DuplicateSpellException;
import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.Shape;
import com.InfinityRaider.elemancy.magic.spell.projectile.*;
import com.InfinityRaider.elemancy.magic.spell.zone.SpellDispell;

public abstract class SpellProjectile extends Spell {
    protected SpellProjectile(Element element1, Element element2, String name) throws DuplicateSpellException {
        super(element1, element2, Shape.PROJECTILE, name);
    }

    static void initSpells() throws DuplicateSpellException {
        new SpellExplosive();
        //TODO: PROJECTILE + FIRE + WATER
        new SpellSpawnLava();
        new SpellBallLightning();
        new SpellForgeElemental();
        new SpellDisarm();
        new SpellSpawnWater();
        new SpellImmobilize();
        new SpellBubble();
        new SpellDuplicate();
        new SpellWaterBolt();
        new SpellStoneDaggers();
        new SpellMagnetSphere();
        new SpellMark();
        new SpellBurryVictim();
        new SpellLightningStrike();
        //TODO: PROJECTILE + AIR + LFIE
        new SpellFear();
        new SpellTeleportHome();
        new SpellMarkPrey();
        new SpellVoidWalk();
    }
}
