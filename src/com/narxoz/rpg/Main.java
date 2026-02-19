package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyDirector;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.combat.FlameBreath;
import com.narxoz.rpg.enemy.BasicEnemy;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.factory.EnemyComponentFactory;
import com.narxoz.rpg.factory.FireComponentFactory;
import com.narxoz.rpg.factory.IceComponentFactory;
import com.narxoz.rpg.factory.ShadowComponentFactory;
import com.narxoz.rpg.prototype.EnemyRegistry;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Enemy System - Creational Patterns Capstone ===\n");

        System.out.println("============================================");
        System.out.println("PART 1: ABSTRACT FACTORY - Themed Components");
        System.out.println("============================================\n");

        EnemyComponentFactory fireFactory = new FireComponentFactory();
        EnemyComponentFactory iceFactory = new IceComponentFactory();
        EnemyComponentFactory shadowFactory = new ShadowComponentFactory();

        showFactory("FIRE", fireFactory);
        showFactory("ICE", iceFactory);
        showFactory("SHADOW", shadowFactory);


        System.out.println("============================================");
        System.out.println("PART 2: BUILDER - Complex Enemy Construction");
        System.out.println("============================================\n");

        Enemy fireDragon = new BossEnemyBuilder()
                .setName("Ancient Fire Dragon")
                .setHealth(50000)
                .setDamage(520)
                .setDefense(240)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAIBehavior(fireFactory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 15000)
                .build();

        fireDragon.displayInfo();

        Enemy basicEnemy = new BasicEnemyBuilder()
                .setName("Ice Raider")
                .setHealth(1200)
                .setDamage(60)
                .setDefense(25)
                .setSpeed(20)
                .setElement("ICE")
                .setAbilities(iceFactory.createAbilities())
                .setLootTable(iceFactory.createLootTable())
                .setAIBehavior(iceFactory.createAIBehavior())
                .build();

        EnemyDirector director = new EnemyDirector(new BossEnemyBuilder());
        Enemy raidBoss = director.createRaidBoss(shadowFactory);
        raidBoss.displayInfo();

        System.out.println("============================================");
        System.out.println("PART 3: PROTOTYPE - Enemy Cloning & Variants");
        System.out.println("============================================\n");

        EnemyRegistry registry = new EnemyRegistry();

        Goblin goblinTemplate = new Goblin("Goblin");
        goblinTemplate.setLootTable(fireFactory.createLootTable());
        goblinTemplate.setAIBehavior("BASIC");

        registry.registerTemplate("goblin", goblinTemplate);
        registry.registerTemplate("fire-dragon", fireDragon);

        Enemy eliteGoblinEnemy = registry.createFromTemplate("goblin");
        if (eliteGoblinEnemy instanceof Goblin eliteGoblin) {
            eliteGoblin.multiplyStats(2.0);
            eliteGoblin.addAbility(new FlameBreath());
            eliteGoblin.setAIBehavior("AGGRESSIVE");
        }
        eliteGoblinEnemy.displayInfo();

        System.out.println("Deep copy test (abilities list should NOT affect template):");
        System.out.println("Template abilities count BEFORE: " + goblinTemplate.getAbilities().size());
        System.out.println("Clone abilities count: " + eliteGoblinEnemy.getAbilities().size());
        System.out.println("Template abilities count AFTER: " + goblinTemplate.getAbilities().size());
        System.out.println();

        System.out.println("============================================");
        System.out.println("PART 4: ALL PATTERNS WORKING TOGETHER");
        System.out.println("============================================\n");

        Enemy demonLord = new BossEnemyBuilder()
                .setName("Demon Lord")
                .setHealth(70000)
                .setDamage(700)
                .setDefense(320)
                .setSpeed(55)
                .setElement("SHADOW")
                .setAbilities(shadowFactory.createAbilities())
                .setLootTable(shadowFactory.createLootTable())
                .setAIBehavior(shadowFactory.createAIBehavior())
                .addPhase(1, 70000)
                .addPhase(2, 42000)
                .addPhase(3, 21000)
                .build();

        registry.registerTemplate("demon-lord", demonLord);

        Enemy greaterDemon = registry.createFromTemplate("demon-lord");
        if (greaterDemon instanceof DragonBoss g) {
            g.multiplyStats(2.0);
            g.setAIBehavior("TACTICAL+");
        }

        Enemy ancientDemon = registry.createFromTemplate("demon-lord");
        if (ancientDemon instanceof DragonBoss a) {
            a.multiplyStats(5.0);
            a.addAbility(new FlameBreath()); // extra ability just to show variation
            a.setAIBehavior("BERSERK");
        }

        demonLord.displayInfo();
        greaterDemon.displayInfo();
        ancientDemon.displayInfo();

        System.out.println("PATTERN SUMMARY");
        System.out.println("============================================");
        System.out.println("Abstract Factory: Fire/Ice/Shadow component families (abilities + loot + AI)");
        System.out.println("Builder: Step-by-step construction of complex enemies");
        System.out.println("Factory Method: builder.build() creates concrete Enemy objects");
        System.out.println("Prototype: EnemyRegistry clones templates (deep copy)\n");

        System.out.println("=== Demo Complete ===");
    }

    private static void showFactory(String themeName, EnemyComponentFactory factory) {
        List<Ability> abilities = factory.createAbilities();
        System.out.println("Theme: " + themeName);
        System.out.println("AI: " + factory.createAIBehavior());
        System.out.println("Abilities:");
        for (Ability a : abilities) {
            System.out.println(" - " + a.getName() + " (power=" + a.getPower() + ")");
        }
        System.out.println("Loot: " + factory.createLootTable().getLootInfo()
                + " | Items: " + factory.createLootTable().getItems());
        System.out.println();
    }
}
