package cz.samelanius.rotator.bot.core.class_packages.playerStructure;

import cz.samelanius.rotator.bot.core.class_packages.CastType;
import lombok.Data;

@Data
public class PlayerData {
    private Resource health = new Resource();
    private Resource mana = new Resource();
    private Resource energy = new Resource();
    private Resource rage = new Resource();

    private boolean isActive;

    private CastType casting;
    private double castingTimeRemaining;

    private boolean isRunning;

    private boolean isPotionCD;

    private int targetHealth;
    private String targetName;

}
