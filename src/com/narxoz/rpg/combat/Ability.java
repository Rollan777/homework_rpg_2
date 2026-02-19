package com.narxoz.rpg.combat;

public interface Ability {

    String getName();

    int getPower();

    String getDescription();

    Ability clone();
}
