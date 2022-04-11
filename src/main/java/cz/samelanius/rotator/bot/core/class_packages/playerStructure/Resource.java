package cz.samelanius.rotator.bot.core.class_packages.playerStructure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class Resource {
    private int value;
    private int maxValue;

    public double getPercentageValue() {
        return (double) value / (double) maxValue;
    }
}
