package com.narxoz.rpg.combat;

public class IceShield implements Ability {

    public String getName() {
        return "Ice Shield";
    }

    public int getPower() {
        return 60;
    }

    public String getDescription() {
        return "Protective shield of ice.";
    }

    public Ability clone() {
        return new IceShield();
    }
}
