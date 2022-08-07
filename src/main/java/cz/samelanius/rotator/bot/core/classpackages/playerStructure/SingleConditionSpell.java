package cz.samelanius.rotator.bot.core.classpackages.playerStructure;

public class SingleConditionSpell implements Spell {
    private final boolean castPossible;

    public SingleConditionSpell(boolean castPossible) {
        this.castPossible = castPossible;
    }

    @Override
    public boolean isCastable() {
        return castPossible;
    }

    @Override
    public String toString() {
        return "is possible: " + castPossible;
    }
}
