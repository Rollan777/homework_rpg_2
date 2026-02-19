package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {

    public String getName() {
        return "Shadow Strike";
    }

    public int getPower() {
        return 110;
    }

    public String getDescription() {
        return "Attack from darkness.";
    }

    public Ability clone() {
        return new ShadowStrike();
    }
}
