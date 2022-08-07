package cz.samelanius.rotator.bot.core;

import cz.samelanius.rotator.bot.core.classpackages.playerStructure.PlayerData;
import cz.samelanius.rotator.bot.core.classpackages.playerStructure.TargetData;

public class ThreatTools {
    public static boolean isSafe(PlayerData player, double scaledPercentageThreshold) {
      //  System.out.println("IsSafe: target= " + player.getTarget() + " spt=" + scaledPercentageThreshold );
        return isSafe(player, scaledPercentageThreshold, Double.MIN_VALUE);
    }

    public static boolean isSafe(PlayerData player, double scaledPercentageThreshold, double valueDiffThreshold) {
        //System.out.println("IsSafe: target= " + player.getTarget() + " spt=" + scaledPercentageThreshold + " vdt=" + valueDiffThreshold);
        TargetData target = player.getTarget();

        if(target.isTanking()) {
          //  System.out.println("is tanking true");
            return false;
        }
        if(target.getThreatScaledPercentage() > scaledPercentageThreshold) {
            //System.out.println("target tsp: " + target.getThreatScaledPercentage());
            return false;
        }
        if(target.getThreatDiff() < valueDiffThreshold) {
            //System.out.println("target tf: " + target.getThreatDiff());
            return false;
        }

        //System.out.println("return true");
        return true;
    }
}