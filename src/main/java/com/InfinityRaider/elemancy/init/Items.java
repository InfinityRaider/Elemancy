package com.InfinityRaider.elemancy.init;

import com.InfinityRaider.elemancy.item.ItemMagicWeapon;
import com.InfinityRaider.elemancy.magic.Shape;
import com.InfinityRaider.elemancy.reference.Names;
import net.minecraft.item.Item;

public class Items {
    public static Item magicStaff;
    public static Item magicWand;
    public static Item magicSword;

    public static void init() {
        magicStaff = new ItemMagicWeapon(Names.Objects.STAFF, Shape.BEAM, Shape.ZONE);
        magicWand = new ItemMagicWeapon(Names.Objects.WAND, Shape.PROJECTILE, Shape.WAVE);
        magicSword = new ItemMagicWeapon(Names.Objects.SWORD, Shape.MELEE, Shape.SHIELD);
    }
}
