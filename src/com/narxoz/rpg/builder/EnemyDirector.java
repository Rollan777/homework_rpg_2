package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    private final EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion() {
        return builder
                .setName("Dungeon Minion")
                .setHealth(60)
                .setDamage(8)
                .setDefense(2)
                .setSpeed(25)
                .setElement("NONE")
                .setAIBehavior("BASIC")
                .build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Mini Boss")
                .setHealth(8000)
                .setDamage(180)
                .setDefense(90)
                .setSpeed(30)
                .setElement("THEMED")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAIBehavior(factory.createAIBehavior())
                .addPhase(1, 8000)
                .addPhase(2, 4000)
                .addPhase(3, 2000)
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        return builder
                .setName("Raid Boss")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(250)
                .setSpeed(45)
                .setElement("THEMED")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAIBehavior(factory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .build();
    }
}
