package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DragonBoss implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;

    private List<Ability> abilities;
    private Map<Integer, Integer> phases;
    private LootTable lootTable;
    private String aiBehavior;

    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public DragonBoss(String name, int health, int damage, int defense,
                      int speed, String element,
                      List<Ability> abilities,
                      int phase1, int phase2, int phase3,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = (abilities != null) ? abilities : new ArrayList<>();

        this.phases = new HashMap<>();
        this.phases.put(1, phase1);
        this.phases.put(2, phase2);
        this.phases.put(3, phase3);

        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
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
        System.out.println("=== " + name + " (Dragon Boss) ===");
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

        System.out.println("Phases:");
        for (Map.Entry<Integer, Integer> p : phases.entrySet()) {
            System.out.println(" Phase " + p.getKey() + " at HP " + p.getValue());
        }

        if (lootTable != null) {
            System.out.println("Loot: " + lootTable.getLootInfo());
        }

        System.out.println("Can Fly: " + canFly +
                " | Breath Attack: " + hasBreathAttack +
                " | Wingspan: " + wingspan);
        System.out.println();
    }


    @Override
    public Enemy clone() {

        List<Ability> abilityCopy = new ArrayList<>();
        for (Ability a : abilities) {
            abilityCopy.add(a.clone());
        }

        LootTable lootCopy = (lootTable == null) ? null : lootTable.clone();

        DragonBoss copy = new DragonBoss(
                name,
                health,
                damage,
                defense,
                speed,
                element,
                abilityCopy,
                phases.getOrDefault(1, 0),
                phases.getOrDefault(2, 0),
                phases.getOrDefault(3, 0),
                lootCopy,
                aiBehavior,
                canFly,
                hasBreathAttack,
                wingspan
        );

        copy.phases = new HashMap<>(this.phases);

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

    public void setElement(String element) {
        this.element = element;
    }

    public void setLootTable(LootTable lootTable) {
        this.lootTable = lootTable;
    }

    public void setAIBehavior(String aiBehavior) {
        this.aiBehavior = aiBehavior;
    }
}
