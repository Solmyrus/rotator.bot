package cz.samelanius.rotator.bot.core.class_packages.classes.baladruid;

import cz.samelanius.rotator.bot.core.class_packages.playerStructure.PlayerParser;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;

public class BalancedDruidParser extends PlayerParser {
    public BalancedDruidPlayerData parseData(RawScreenData data) {
        return parseData(data, new BalancedDruidPlayerData());
    }

    public BalancedDruidPlayerData parseData(RawScreenData rawScreenData, BalancedDruidPlayerData playerData) {
        BalancedDruidRawData data = parseFromJson(rawScreenData, BalancedDruidRawData.class);

        super.parseBaseData(data, playerData);

        playerData.getSpellMoonFire().setConditions(data.isMoonfireEnabled(), data.isMoonfireWithDotPossible());
        playerData.getSpellRepeatableMoonFire().setConditions(data.isMoonfireEnabled(), data.isMoonfirePossible());
        playerData.getSpellStarFire().setConditions(data.isStarfireEnabled(), data.isStarfirePossible());
        playerData.getSpellInsectSwarm().setConditions(data.isInsectswarmEnabled(), data.isInsectswarmPossible());
        playerData.getSpellFaerieFire().setConditions(data.isFfEnabled(), data.isFaerieFirePossible());

        playerData.setActivateManaPotion(data.isActivateManaPotion());
        playerData.setActivateDarkRune(data.isActivateDarkRune());
        playerData.setActivateTrinket(data.isActivateTrinket());
        playerData.setActivateDrums(data.isActivateDrums());
        playerData.setActivateInnervate(data.isActivateInnervate());

        playerData.setDarkRuneCD(data.isDarkRuneCD());
        playerData.setRunningModeEnable(data.isRunningModeEnabled());

        return playerData;

    }


}
