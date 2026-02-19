package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {

    public String getName() {
        return "Frost Breath";
    }

    public int getPower() {
        return 100;
    }

    public String getDescription() {
        return "Freezing breath slows enemies.";
    }

    public Ability clone() {
        return new FrostBreath();
    }
}
