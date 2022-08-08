package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerData;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.SingleConditionSpell;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.Spell;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.TwoConditionSpell;
import lombok.Data;

@Data
public class BalancedDruidWotlkPlayerData extends PlayerData {
    private Spell spellStarFire;
    private Spell wrath;

    private TwoConditionSpell spellStarFall = new TwoConditionSpell(true);
    private TwoConditionSpell spellFaerieFire = new TwoConditionSpell(true);
    private TwoConditionSpell spellMoonFire = new TwoConditionSpell(true);
    private TwoConditionSpell spellInsectSwarm = new TwoConditionSpell(true);


    private boolean lunarEclipseAura;
    private boolean solarEclipseAura;

    private boolean isRunningModeEnable;
    private boolean isDarkRuneCD;

    private boolean activateManaPotion;
    private boolean activateDarkRune;
    private boolean activateTrinket;
    private boolean activateDrums;
    private boolean activateInnervate;
    private boolean activateDestructionPotion;

    private boolean threatLock;
}
