package cz.samelanius.rotator.bot.core.class_packages.classes.protwar;

import cz.samelanius.rotator.bot.core.class_packages.playerStructure.PlayerData;
import lombok.Data;

@Data
public class ProtWarPlayerData extends PlayerData {
    private boolean possibleRevenge;
    private boolean possibleShieldSlam;
    private boolean possibleShieldBlock;
    private boolean possibleDevastate;
    private boolean possibleHeroicStrike;
}
