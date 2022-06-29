package cz.samelanius.rotator.bot.core.classpackages.classes.protwar;

import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerData;
import lombok.Data;

@Data
public class ProtWarPlayerData extends PlayerData {
    private boolean possibleRevenge;
    private boolean possibleShieldSlam;
    private boolean possibleShieldBlock;
    private boolean possibleDevastate;
    private boolean possibleHeroicStrike;
}
