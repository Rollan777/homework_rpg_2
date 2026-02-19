package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.BasicEnemy;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health = 1;
    private int damage = 1;
    private int defense = 0;
    private int speed = 1;

    private String element = "NONE";
    private String aiBehavior = "BASIC";

    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    @Override public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }

    @Override public EnemyBuilder setElement(String element) { this.element = element; return this; }
    @Override public EnemyBuilder setAIBehavior(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }

    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = (abilities == null) ? new ArrayList<>() : new ArrayList<>(abilities);
        return this;
    }

    @Override
    public EnemyBuilder addAbility(Ability ability) {
        if (ability != null) abilities.add(ability);
        return this;
    }

    @Override public EnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Enemy must have a name");
        }
        if (health <= 0) {
            throw new IllegalStateException("Enemy must have health > 0");
        }

        return new BasicEnemy(
                name,
                health, damage, defense, speed,
                element,
                abilities,
                lootTable,
                aiBehavior
        );
    }
}
