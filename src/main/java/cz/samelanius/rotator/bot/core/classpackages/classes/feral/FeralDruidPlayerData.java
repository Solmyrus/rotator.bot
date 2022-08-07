package cz.samelanius.rotator.bot.core.classpackages.classes.feral;

import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerData;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.Spell;
import lombok.Data;

@Data
public class FeralDruidPlayerData extends PlayerData {

    private FeralDruidStrategyType strategy;

    private int comboPoints;

    private Spell rip;
    private Spell shred;
    private Spell catMangle;
    private Spell catForm;

    private DruidForm form;
}
