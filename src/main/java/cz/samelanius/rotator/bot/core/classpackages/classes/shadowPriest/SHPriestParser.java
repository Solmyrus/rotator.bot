package cz.samelanius.rotator.bot.core.classpackages.classes.shadowPriest;

import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerParser;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;

public class SHPriestParser extends PlayerParser {

    public SHPriestPlayerData parseData(RawScreenData rawScreenData) {

        SHPriestRawData data = parseFromJson(rawScreenData, SHPriestRawData.class);
        if(data == null) return null;


        SHPriestPlayerData playerData = new SHPriestPlayerData();
        super.parseBaseData(data, playerData);

        playerData.getMindBlast().setConditions(data.isMindBlastActive(), data.isMindBlastPossible());
        playerData.getVampiricEmbrace().setConditions(data.isVampiricEmbranceActive(), data.isVampiricEmbrancePossible());
        playerData.getVampiricTouch().setConditions(data.isVampiricTouchActive(), data.isVampiricTouchPossible());
        playerData.getShadowWordPain().setConditions(data.isShadowWordPainActive(), data.isShadowWordPainPossible());
        playerData.getMindFly().setConditions(data.isMindFlayActive(), data.isMindFlayPossible());
        playerData.getPowerWordShield().setConditions(data.isPowerWordShieldActive(), data.isPowerWordShieldPossible());


        return playerData;

    }

}
