package com.narxoz.rpg.combat;

public class DarkNova implements Ability {

    public String getName() {
        return "Dark Nova";
    }

    public int getPower() {
        return 190;
    }

    public String getDescription() {
        return "Explosive burst of shadow energy.";
    }

    public Ability clone() {
        return new DarkNova();
    }
}
