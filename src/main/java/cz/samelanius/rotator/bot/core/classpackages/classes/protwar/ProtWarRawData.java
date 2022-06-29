package cz.samelanius.rotator.bot.core.classpackages.classes.protwar;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.samelanius.rotator.bot.core.classpackages.BasePlayerRawData;
import lombok.Data;

@Data
public class ProtWarRawData extends BasePlayerRawData {

    @JsonProperty("rev")
    private boolean possibleRevenge;

    @JsonProperty("ss")
    private boolean possibleShieldSlam;

    @JsonProperty("sb")
    private boolean possibleShieldBlock;

    @JsonProperty("dev")
    private boolean possibleDevastate;

    @JsonProperty("hs")
    private boolean possibleHeroicStrike;
}
