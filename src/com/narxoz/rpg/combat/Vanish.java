package com.narxoz.rpg.combat;

public class Vanish implements Ability {

    public String getName() {
        return "Vanish";
    }

    public int getPower() {
        return 0;
    }

    public String getDescription() {
        return "Become invisible temporarily.";
    }

    public Ability clone() {
        return new Vanish();
    }
}
