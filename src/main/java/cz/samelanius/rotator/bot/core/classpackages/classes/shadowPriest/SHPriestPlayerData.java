package cz.samelanius.rotator.bot.core.classpackages.classes.shadowPriest;

import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerData;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.SingleConditionSpell;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.Spell;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.TwoConditionSpell;
import lombok.Data;

@Data
public class SHPriestPlayerData extends PlayerData {
    private TwoConditionSpell mindBlast = new TwoConditionSpell(true);
    private TwoConditionSpell vampiricEmbrace = new TwoConditionSpell(true);
    private TwoConditionSpell vampiricTouch = new TwoConditionSpell(true);
    private TwoConditionSpell shadowWordPain = new TwoConditionSpell(true);
    private TwoConditionSpell mindFly = new TwoConditionSpell(true);

}
