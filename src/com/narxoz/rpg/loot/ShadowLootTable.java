package com.narxoz.rpg.loot;

import java.util.List;

public class ShadowLootTable implements LootTable {

    public List<String> getItems() {
        return List.of("Shadow Gem", "Dark Essence", "Shadow Rune");
    }

    public int getGoldDrop() {
        return 550;
    }

    public int getExperienceDrop() {
        return 320;
    }

    public String getLootInfo() {
        return "Shadow themed loot";
    }

    public LootTable clone() {
        return new ShadowLootTable();
    }
}
