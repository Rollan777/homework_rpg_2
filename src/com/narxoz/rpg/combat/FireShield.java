package com.narxoz.rpg.combat;

public class FireShield implements Ability {

    public String getName() {
        return "Fire Shield";
    }

    public int getPower() {
        return 50;
    }

    public String getDescription() {
        return "Burning shield that reduces damage.";
    }

    public Ability clone() {
        return new FireShield();
    }
}
