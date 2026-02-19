package com.narxoz.rpg.combat;

public class Blizzard implements Ability {

    public String getName() {
        return "Blizzard";
    }

    public int getPower() {
        return 180;
    }

    public String getDescription() {
        return "Massive snowstorm damages all enemies.";
    }

    public Ability clone() {
        return new Blizzard();
    }
}
