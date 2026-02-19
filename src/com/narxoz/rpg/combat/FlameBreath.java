package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {

    public String getName() {
        return "Flame Breath";
    }

    public int getPower() {
        return 120;
    }

    public String getDescription() {
        return "Dragon breathes fire dealing massive damage.";
    }

    public Ability clone() {
        return new FlameBreath();
    }
}
