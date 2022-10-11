package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.samelanius.rotator.bot.core.classpackages.BasePlayerRawData;
import lombok.Data;

@Data
public class BalancedDruidWotlkRawData extends BasePlayerRawData {

    @JsonProperty("psf")
    private boolean starfirePossible;

    @JsonProperty("pw")
    private boolean wrathPossible;

    @JsonProperty("psfa")
    private boolean starfallPossible;

    @JsonProperty("pff")
    private boolean faerieFirePossible;

    @JsonProperty("pmfd")
    private boolean moonfireWithDotPossible;

    @JsonProperty("pis")
    private boolean insectswarmPossible;


    @JsonProperty("esfa")
    private boolean starfallEnabled;

    @JsonProperty("eff")
    private boolean ffEnabled;

    @JsonProperty("emf")
    private boolean moonfireEnabled;

    @JsonProperty("eis")
    private boolean insectswarmEnabled;


    @JsonProperty("sea")
    private boolean solarEclipseAura;

    @JsonProperty("lea")
    private boolean lunarEclipseAura;




    @JsonProperty("ap1")
    private boolean activatePotion1;

    @JsonProperty("ap2")
    private boolean activatePotion2;

    @JsonProperty("ai")
    private boolean activateInnervate;

}
