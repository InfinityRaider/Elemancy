package com.InfinityRaider.elemancy.magic;

import com.InfinityRaider.elemancy.magic.spell.Spell;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.HashMap;

public enum Shape {
    PROJECTILE,
    BEAM,
    WAVE,
    SHIELD,
    ZONE,
    MELEE;

    private HashMap<Element, HashMap<Element, Spell>> spells = new HashMap<Element, HashMap<Element, Spell>>();

    public final boolean isChanneled(Element playerElement, Element weaponElement) {
        return getSpell(playerElement, weaponElement).isChanneled();
    }

    public final void castSpell(World world, int x, int y, int z, EntityPlayer player, Element playerElement, int playerLevel, Element weaponElement, int weaponLevel, int channelTime) {
        Spell spell = this.getSpell(playerElement, weaponElement);
        spell.castSpell(world, x, y, z, player, playerLevel, weaponLevel, channelTime);
    }

    public final void onSpellStopChannel(World world, int x, int y, int z, EntityPlayer player, Element playerElement, int playerLevel, Element weaponElement, int weaponLevel, int channelTime){
        Spell spell = this.getSpell(playerElement, weaponElement);
        spell.onStopChannel(world, x, y, z, player, playerLevel, weaponLevel, channelTime);
    }

    @SideOnly(Side.CLIENT)
    public final void performClientSideStuff(World world, int x, int y, int z, EntityPlayer player, Element playerElement, int playerLevel, Element castElement, int weaponLevel, int channelTime) {
        Spell spell = this.getSpell(playerElement, castElement);
        spell.spellParticles(world, x, y, z, player, playerLevel, weaponLevel, channelTime);
    }

    public Spell getSpell(Element e1, Element e2) {
        int a = e1.ordinal();
        int b = e2.ordinal();
        return spells.get(a<=b?e1:e2).get(a <= b ? e2 : e1);
    }

    public void registerSpell(Spell spell) throws DuplicateSpellException{
        Element[] elements = spell.getElements();
        HashMap<Element, Spell> mapForEntry = spells.get(elements[0]);
        if(mapForEntry == null) {
            mapForEntry = new HashMap<Element, Spell>();
            mapForEntry.put(elements[1], spell);
            spells.put(elements[0], mapForEntry);
        }
        else {
            if(mapForEntry.get(elements[1])!=null) {
                throw new DuplicateSpellException(this, elements[0], elements[1]);
            }
            mapForEntry.put(elements[1], spell);
        }
    }
}
