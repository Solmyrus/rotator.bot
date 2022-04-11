package cz.samelanius.rotator.bot.core.class_packages;

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

    @JsonProperty("me")
    private int maxMana;

    @JsonProperty("ae")
    private int mana;

    @JsonProperty("cast")
    private CastType casting;

    @JsonProperty("castTimeRem")
    private double castingTimeRemaining;


    @JsonProperty("run")
    private boolean isRunning;

    @JsonProperty("potionCD")
    private boolean potionCD;

}
