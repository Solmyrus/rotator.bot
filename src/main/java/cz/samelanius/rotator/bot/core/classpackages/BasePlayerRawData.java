package cz.samelanius.rotator.bot.core.classpackages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BasePlayerRawData {
    @JsonProperty("profile")
    private String profile;

    @JsonProperty("act")
    private boolean active;

    @JsonProperty("mh")
    private int maxHealth;

    @JsonProperty("ah")
    private int health;

    @JsonProperty("maxMana")
    private int maxMana;

    @JsonProperty("mana")
    private int mana;

    @JsonProperty("maxRage")
    private int maxRage;

    @JsonProperty("rage")
    private int rage;

    @JsonProperty("maxEnergy")
    private int maxEnergy;

    @JsonProperty("energy")
    private int energy;

    @JsonProperty("cast")
    private CastType casting;

    @JsonProperty("castTimeRem")
    private double castingTimeRemaining;


    @JsonProperty("run")
    private boolean isRunning;

    @JsonProperty("potionCD")
    private boolean potionCD;


    @JsonProperty("th")
    private int targetHealth;

    @JsonProperty("tn")
    private String targetName;

}
