package cz.samelanius.rotator.bot.core.class_packages.playerStructure;

import lombok.Setter;

public class TwoConditionSpell implements Spell {
    private boolean andCondition;

    @Setter
    private boolean condition1;

    @Setter
    private boolean condition2;

    public TwoConditionSpell(boolean andCondition) {
        this.andCondition = andCondition;
    }


    public void setConditions(boolean condition1, boolean condition2) {
        this.condition1 = condition1;
        this.condition2 = condition2;
    }

    @Override
    public boolean isCastable() {
        if(andCondition) {
            return condition1 && condition2;
        } else {
            return condition1 || condition2;
        }
    }
}
