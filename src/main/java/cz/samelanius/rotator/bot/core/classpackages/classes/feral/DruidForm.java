package cz.samelanius.rotator.bot.core.classpackages.classes.feral;

public enum DruidForm {
    UNKNOWN,
    CAT,
    BEAR;


    public static DruidForm getForm(int index) {
        switch (index) {
            case 3: return CAT;
            case 1: return BEAR;
            default: return UNKNOWN;
        }
    }
}
