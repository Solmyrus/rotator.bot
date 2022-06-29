package cz.samelanius.rotator.bot.core.class_packages.classes.shadowPriest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SHPriestRawData {
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
}
