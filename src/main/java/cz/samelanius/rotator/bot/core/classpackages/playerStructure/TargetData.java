package cz.samelanius.rotator.bot.core.classpackages.playerStructure;

import lombok.Data;

@Data
public class TargetData {

    private int targetHealth;

    private String targetName;

    private boolean isTanking;

    private TankingStatus tankingStatus;

    private double threatScaledPercentage;

    private double threatRawPercentage;

    private double threatValue;

    private double threatDiff;

    private double threatTank;

}
