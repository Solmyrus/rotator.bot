package cz.samelanius.rotator.bot.core.classpackages.classes.feral;

import com.fasterxml.jackson.annotation.JsonProperty;
import cz.samelanius.rotator.bot.core.classpackages.BasePlayerRawData;
import lombok.Data;

@Data
public class FeralDruidRawData extends BasePlayerRawData {

    @JsonProperty("feralStrategy")
    private String feralStrategy;

    @JsonProperty("cp")
    private int comboPoints;

    @JsonProperty("shredp")
    private boolean shreadPossible;

    @JsonProperty("manglep")
    private boolean catManglePossible;

    @JsonProperty("ripp")
    private boolean ripPossible;

    @JsonProperty("catFormp")
    private boolean catFormPossible;

    @JsonProperty("form")
    private int form;

}
