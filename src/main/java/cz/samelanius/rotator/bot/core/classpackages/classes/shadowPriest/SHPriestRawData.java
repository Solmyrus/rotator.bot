package cz.samelanius.rotator.bot.core.classpackages.classes.shadowPriest;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.samelanius.rotator.bot.core.classpackages.BasePlayerRawData;
import lombok.Data;

@Data
public class SHPriestRawData extends BasePlayerRawData {
    @JsonProperty("pmb")
    private boolean mindBlastPossible;

    @JsonProperty("pvt")
    private boolean vampiricTouchPossible;

    @JsonProperty("pswp")
    private boolean shadowWordPainPossible;

    @JsonProperty("pve")
    private boolean vampiricEmbrancePossible;

    @JsonProperty("pmf")
    private boolean mindFlayPossible;

    @JsonProperty("amb")
    private boolean mindBlastActive;

    @JsonProperty("avt")
    private boolean vampiricTouchActive;

    @JsonProperty("aswp")
    private boolean shadowWordPainActive;

    @JsonProperty("ave")
    private boolean vampiricEmbranceActive;

    @JsonProperty("amf")
    private boolean mindFlayActive;

}
