package cz.samelanius.rotator.bot.core.class_packages.classes.baladruid;

import cz.samelanius.rotator.bot.core.class_packages.playerStructure.PlayerData;
import cz.samelanius.rotator.bot.core.class_packages.playerStructure.Spell;
import cz.samelanius.rotator.bot.core.class_packages.playerStructure.TwoConditionSpell;
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

}
