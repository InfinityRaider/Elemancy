package com.InfinityRaider.elemancy.magic;

public class DuplicateSpellException extends Exception {
    public DuplicateSpellException(Shape shape, Element e1, Element e2) {
        super("A spell already exists for this shape ("+shape.name()+") and elements (" + e1.name() +", " + e2.name()+")");
    }
}
