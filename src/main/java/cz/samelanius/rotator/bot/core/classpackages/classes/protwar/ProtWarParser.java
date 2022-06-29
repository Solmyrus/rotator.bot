package cz.samelanius.rotator.bot.core.classpackages.classes.protwar;

import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerParser;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;

public class ProtWarParser  extends PlayerParser {
    public ProtWarPlayerData parseData(RawScreenData rawScreenData, ProtWarPlayerData playerData) {
        ProtWarRawData data = parseFromJson(rawScreenData, ProtWarRawData.class);

        super.parseBaseData(data, playerData);

        playerData.setPossibleRevenge(data.isPossibleRevenge());
        playerData.setPossibleShieldBlock(data.isPossibleShieldBlock());
        playerData.setPossibleShieldSlam(data.isPossibleShieldSlam());
        playerData.setPossibleDevastate(data.isPossibleDevastate());
        playerData.setPossibleHeroicStrike(data.isPossibleHeroicStrike());

        return playerData;
    }
}
