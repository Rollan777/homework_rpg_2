package com.narxoz.rpg.loot;

import java.util.List;

public class FireLootTable implements LootTable {

    public List<String> getItems() {
        return List.of("Fire Gem", "Dragon Scale", "Flame Rune");
    }

    public int getGoldDrop() {
        return 500;
    }

    public int getExperienceDrop() {
        return 300;
    }

    public String getLootInfo() {
        return "Fire themed loot";
    }

    public LootTable clone() {
        return new FireLootTable();
    }
}
