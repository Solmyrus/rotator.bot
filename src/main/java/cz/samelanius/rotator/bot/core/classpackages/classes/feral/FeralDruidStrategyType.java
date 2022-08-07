package cz.samelanius.rotator.bot.core.classpackages.classes.feral;

public enum FeralDruidStrategyType {
    CAT_FRONTAL,
    CAT_REAR,
    BEAR_TANK;

    public static FeralDruidStrategyType getStrategy(String name) {
        if(name == null) return null;
        switch (name) {
            case "cf": return CAT_FRONTAL;
            case "cr": return CAT_REAR;
            case "bt": return BEAR_TANK;
        }
        return null;
    }
}
