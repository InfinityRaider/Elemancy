package com.InfinityRaider.elemancy.magic.spell;

import com.InfinityRaider.elemancy.magic.DuplicateSpellException;
import com.InfinityRaider.elemancy.magic.Element;
import com.InfinityRaider.elemancy.magic.Shape;
import com.InfinityRaider.elemancy.utility.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.ArrayList;

public abstract class Spell {
    public static final ArrayList<Spell> spells = new ArrayList<Spell>();

    private Element element1;
    private Element element2;

    private Shape shape;

    private String name;

    Spell(Element element1, Element element2, Shape shape, String name) throws DuplicateSpellException {
        int a = element1.ordinal();
        int b = element2.ordinal();
        this.element1 = a<=b?element1:element2;
        this.element2 = a<=b?element2:element1;
        this.shape = shape;
        this.name = "elemancy_spell." + name;
        shape.registerSpell(this);
        spells.add(this);
    }

    public static void init() {
        if(spells.size() == 0) {
            //staff primary: beam
            try {
                SpellBeam.initSpells();
            } catch(DuplicateSpellException e) {
                LogHelper.printStackTrace(e);
            }
            //staff secondary: zone
            try {
                SpellZone.initSpells();
            } catch(DuplicateSpellException e) {
                LogHelper.printStackTrace(e);
            }
            //sword primary: melee
            try {
                SpellMelee.initSpells();
            } catch(DuplicateSpellException e) {
                LogHelper.printStackTrace(e);
            }
            //sword secondary: shield
            try {
                SpellShield.initSpells();
            } catch(DuplicateSpellException e) {
                LogHelper.printStackTrace(e);
            }
            //wand primary: projectile
            try {
                SpellProjectile.initSpells();
            } catch(DuplicateSpellException e) {
                LogHelper.printStackTrace(e);
            }
            //wand secondary: zone
            try {
                SpellWave.initSpells();
            } catch(DuplicateSpellException e) {
                LogHelper.printStackTrace(e);
            }
        }
    }

    /** returns an array containing both elements of this spell ordered by ordinal */
    public Element[] getElements() {
        return new Element[] {element1, element2};
    }

    public String getName() {
        return this.name;
    }

    public Shape getShape() {
        return this.shape;
    }

    public double getModifier(Element target) {
        return this.element1.modifier(target) * this.element2.modifier(target);
    }

    public abstract boolean isChanneled();

    public abstract void castSpell(World world, int x, int y, int z, EntityPlayer player, int lvl1, int lvl2, int channelTicks);

    public abstract void onStopChannel(World world, int x, int y, int z, EntityPlayer player, int lvl1, int lvl2, int channelTicks);

    @SideOnly(Side.CLIENT)
    public abstract void spellParticles(World world, int x, int y, int z, EntityPlayer player, int lvl1, int lvl2, int channelTicks);
}
