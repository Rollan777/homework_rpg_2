package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemy implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;
    private String aiBehavior;

    private List<Ability> abilities;
    private LootTable lootTable;

    public BasicEnemy(String name,
                      int health, int damage, int defense, int speed,
                      String element,
                      List<Ability> abilities,
                      LootTable lootTable,
                      String aiBehavior) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = (element == null) ? "NONE" : element;
        this.aiBehavior = (aiBehavior == null) ? "BASIC" : aiBehavior;

        this.abilities = (abilities == null) ? new ArrayList<>() : new ArrayList<>(abilities);
        this.lootTable = lootTable;
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }
    @Override public String getElement() { return element; }
    @Override public String getAIBehavior() { return aiBehavior; }

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
        System.out.println("=== " + name + " (Basic Enemy) ===");
        System.out.println("Health: " + health +
                " | Damage: " + damage +
                " | Defense: " + defense +
                " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI: " + aiBehavior);

        System.out.println("Abilities (" + abilities.size() + "):");
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
        List<Ability> abilityCopy = new ArrayList<>();
        for (Ability a : abilities) {
            abilityCopy.add(a.clone());
        }
        LootTable lootCopy = (lootTable == null) ? null : lootTable.clone();

        return new BasicEnemy(
                name, health, damage, defense, speed,
                element,
                abilityCopy,
                lootCopy,
                aiBehavior
        );
    }

    public void multiplyStats(double k) {
        health = (int) (health * k);
        damage = (int) (damage * k);
        defense = (int) (defense * k);
        speed = (int) (speed * k);
    }

    public void addAbility(Ability a) {
        abilities.add(a);
    }

    public void setLootTable(LootTable lt) {
        lootTable = lt;
    }

    public void setAIBehavior(String ai) {
        aiBehavior = ai;
    }

    public void setElement(String el) {
        element = el;
    }
}
