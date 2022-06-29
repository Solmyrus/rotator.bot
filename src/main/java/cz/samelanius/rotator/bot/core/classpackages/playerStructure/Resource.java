package cz.samelanius.rotator.bot.core.classpackages.playerStructure;

import lombok.Data;

@Data
public class Resource {
    private int value;
    private int maxValue;

    public double getPercentageValue() {
        return (double) value / (double) maxValue;
    }
}
