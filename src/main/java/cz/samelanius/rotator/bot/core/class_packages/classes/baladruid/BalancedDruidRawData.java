package cz.samelanius.rotator.bot.core.class_packages.classes.baladruid;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.samelanius.rotator.bot.core.class_packages.BasePlayerRawData;
import lombok.Data;

@Data
public class BalancedDruidRawData extends BasePlayerRawData {

    @JsonProperty("pmf")
    private boolean moonfirePossible;

    @JsonProperty("pmfd")
    private boolean moonfireWithDotPossible;

    @JsonProperty("psf")
    private boolean starfirePossible;

    @JsonProperty("pis")
    private boolean insectswarmPossible;

    @JsonProperty("pff")
    private boolean faerieFirePossible;


    @JsonProperty("emf")
    private boolean moonfireEnabled;

    @JsonProperty("esf")
    private boolean starfireEnabled;

    @JsonProperty("eis")
    private boolean insectswarmEnabled;

    @JsonProperty("eff")
    private boolean ffEnabled;

    @JsonProperty("rm")
    private boolean runningModeEnabled;

    @JsonProperty("darkRuneCD")
    private boolean darkRuneCD;
}
