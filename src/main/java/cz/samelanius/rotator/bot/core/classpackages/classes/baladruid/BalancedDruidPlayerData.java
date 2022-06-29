package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerData;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.TwoConditionSpell;
import lombok.Data;

@Data
public class BalancedDruidPlayerData extends PlayerData {
    private TwoConditionSpell spellMoonFire = new TwoConditionSpell(true);
    private TwoConditionSpell spellRepeatableMoonFire = new TwoConditionSpell(true);
    private TwoConditionSpell spellStarFire = new TwoConditionSpell(true);
    private TwoConditionSpell spellInsectSwarm = new TwoConditionSpell(true);
    private TwoConditionSpell spellFaerieFire = new TwoConditionSpell(true);

    private boolean isRunningModeEnable;
    private boolean isDarkRuneCD;

    private boolean activateManaPotion;
    private boolean activateDarkRune;
    private boolean activateTrinket;
    private boolean activateDrums;
    private boolean activateInnervate;
    private boolean activateDestructionPotion;

}
