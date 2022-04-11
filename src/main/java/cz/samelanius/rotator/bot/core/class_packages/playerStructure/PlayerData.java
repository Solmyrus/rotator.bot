package cz.samelanius.rotator.bot.core.class_packages.playerStructure;

import lombok.Data;

@Data
public class PlayerData {
    private Resource health = new Resource();
    private Resource mana = new Resource();
    private Resource energy = new Resource();
    private Resource rage = new Resource();

    private boolean isActive;
    private boolean isCasting;
    private boolean isRunning;

    private boolean isPotionCD;
}
