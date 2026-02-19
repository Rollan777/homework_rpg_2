package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class Goblin implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;
    private String aiBehavior;

    private List<Ability> abilities;
    private LootTable lootTable;

    public Goblin(String name) {
        this.name = name;

        this.health = 100;
        this.damage = 15;
        this.defense = 5;
        this.speed = 35;

        // Defaults
        this.element = "NONE";
        this.aiBehavior = "BASIC";

        this.abilities = new ArrayList<>();
        this.lootTable = null;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public int getDefense() {
        return defense;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String getElement() {
        return element;
    }

    @Override
    public String getAIBehavior() {
        return aiBehavior;
    }

    @Override
    public List<Ability> getAbilities() {
        return new ArrayList<>(abilities);
    }

    @Override
    public LootTable getLootTable() {
        return lootTable;
    }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Goblin) ===");
        System.out.println("Health: " + health +
                " | Damage: " + damage +
                " | Defense: " + defense +
                " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);

        System.out.println("Abilities:");
        for (Ability a : abilities) {
            System.out.println(" - " + a.getName() + " (power=" + a.getPower() + ")");
        }

        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo()
                    + " | Gold: " + lootTable.getGoldDrop()
                    + " | XP: " + lootTable.getExperienceDrop()
                    + " | Items: " + lootTable.getItems());
        } else {
            System.out.println("Loot: none");
        }

        System.out.println();
    }

    @Override
    public Enemy clone() {
        Goblin copy = new Goblin(this.name);

        copy.health = this.health;
        copy.damage = this.damage;
        copy.defense = this.defense;
        copy.speed = this.speed;

        copy.element = this.element;
        copy.aiBehavior = this.aiBehavior;

        copy.abilities = new ArrayList<>();
        for (Ability a : this.abilities) {
            copy.abilities.add(a.clone());
        }

        copy.lootTable = (this.lootTable == null) ? null : this.lootTable.clone();

        return copy;
    }

    public void multiplyStats(double multiplier) {
        health = (int) (health * multiplier);
        damage = (int) (damage * multiplier);
        defense = (int) (defense * multiplier);
        speed = (int) (speed * multiplier);
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    public void setAIBehavior(String aiBehavior) {
        this.aiBehavior = aiBehavior;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
