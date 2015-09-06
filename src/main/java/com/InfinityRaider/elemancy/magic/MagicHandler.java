package com.InfinityRaider.elemancy.magic;

import com.InfinityRaider.elemancy.utility.LogHelper;
import net.minecraft.entity.Entity;

public class MagicHandler {
    public static PlayerMagicProperty getMagicProperty(Entity entity) {
        return (PlayerMagicProperty) entity.getExtendedProperties(PlayerMagicProperty.KEY);
    }

    public static Element getMagicElement(Entity entity) {
        PlayerMagicProperty prop = getMagicProperty(entity);
        if(prop == null) {
            LogHelper.error("No property found for entity " + entity.toString());
            return null;
        }
        return prop.getElement();
    }

    public static int getMagicLevel(Entity entity) {
        PlayerMagicProperty prop = getMagicProperty(entity);
        if(prop == null) {
            LogHelper.error("No property found for entity " + entity.toString());
            return 0;
        }
        return prop.getLevel();
    }

    public static void setMagicElement(Entity entity, Element e) {
        PlayerMagicProperty prop = getMagicProperty(entity);
        if(prop == null) {
            LogHelper.error("No property found for entity " + entity.toString());
            return;
        }
        prop.setElement(e);
    }

    public static void setMagicLevel(Entity entity, int lvl) {
        PlayerMagicProperty prop = getMagicProperty(entity);
        if(prop == null) {
            LogHelper.error("No property found for entity " + entity.toString());
            return;
        }
        prop.setLevel(lvl);
    }

    public static void increaseMagicLevel(Entity entity) {
        PlayerMagicProperty prop = getMagicProperty(entity);
        if(prop == null) {
            LogHelper.error("No property found for entity " + entity.toString());
            return;
        }
        prop.setLevel(prop.getLevel()+1);
    }

    public static void resetMagicLevel(Entity entity) {
        PlayerMagicProperty prop = getMagicProperty(entity);
        if(prop == null) {
            LogHelper.error("No property found for entity " + entity.toString());
            return;
        }
        prop.setLevel(0);
    }
}
