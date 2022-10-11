package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk;

import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerParser;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.SingleConditionSpell;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;

public class BalancedDruidWotlkParser extends PlayerParser {

    public BalancedDruidWotlkPlayerData parseData(RawScreenData rawScreenData) {

        BalancedDruidWotlkRawData data = parseFromJson(rawScreenData, BalancedDruidWotlkRawData.class);
        if(data == null) return null;


        BalancedDruidWotlkPlayerData playerData = new BalancedDruidWotlkPlayerData();
        super.parseBaseData(data, playerData);


        playerData.setWrath(new SingleConditionSpell(data.isWrathPossible()));
        playerData.setSpellStarFire(new SingleConditionSpell(data.isStarfirePossible()));
        playerData.getSpellStarFall().setConditions(data.isStarfallEnabled(), data.isStarfallPossible());
        playerData.getSpellFaerieFire().setConditions(data.isFfEnabled(), data.isFaerieFirePossible());
        playerData.getSpellMoonFire().setConditions(data.isMoonfireEnabled(), data.isMoonfireWithDotPossible());
        playerData.getSpellInsectSwarm().setConditions(data.isInsectswarmEnabled(), data.isInsectswarmPossible());

        playerData.setLunarEclipseAura(data.isLunarEclipseAura());
        playerData.setSolarEclipseAura(data.isSolarEclipseAura());

        playerData.setActivatePotion1(data.isActivatePotion1());
        playerData.setActivatePotion2(data.isActivatePotion2());
        playerData.setActivateInnervate(data.isActivateInnervate());

        return playerData;

    }


}
