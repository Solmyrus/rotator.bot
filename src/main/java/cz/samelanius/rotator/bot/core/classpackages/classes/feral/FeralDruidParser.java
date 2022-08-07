package cz.samelanius.rotator.bot.core.classpackages.classes.feral;

import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerParser;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.SingleConditionSpell;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;

public class FeralDruidParser extends PlayerParser {
    public FeralDruidPlayerData parseData(RawScreenData rawScreenData) {
        FeralDruidRawData data = parseFromJson(rawScreenData, FeralDruidRawData.class);
        if(data == null) return null;

        FeralDruidPlayerData playerData = new FeralDruidPlayerData();

        super.parseBaseData(data, playerData);

        playerData.setStrategy(FeralDruidStrategyType.getStrategy(data.getFeralStrategy()));
        playerData.setComboPoints(data.getComboPoints());

        playerData.setRip(new SingleConditionSpell(data.isRipPossible()));
        playerData.setCatMangle(new SingleConditionSpell(data.isCatManglePossible()));
        playerData.setShred(new SingleConditionSpell(data.isShreadPossible()));
        playerData.setCatForm(new SingleConditionSpell(data.isCatFormPossible()));

        playerData.setForm(DruidForm.getForm(data.getForm()));

        return playerData;

    }

}
