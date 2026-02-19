package com.narxoz.rpg.combat;

public class MeteorStorm implements Ability {

    public String getName() {
        return "Meteor Storm";
    }

    public int getPower() {
        return 200;
    }

    public String getDescription() {
        return "Summons meteors from the sky.";
    }

    public Ability clone() {
        return new MeteorStorm();
    }
}
