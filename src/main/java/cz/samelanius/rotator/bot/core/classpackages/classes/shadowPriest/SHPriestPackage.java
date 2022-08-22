package cz.samelanius.rotator.bot.core.classpackages.classes.shadowPriest;

import cz.samelanius.rotator.bot.core.classpackages.AbstractClassPackage;
import cz.samelanius.rotator.bot.core.classpackages.CastType;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.actions.KeyPress;
import cz.samelanius.rotator.bot.core.engine.actions.ResultActions;

import static cz.samelanius.rotator.bot.core.classpackages.classes.shadowPriest.SHPriestKeybindigs.*;

public class SHPriestPackage extends AbstractClassPackage {

    public static final String PACKAGE_ID = "sh_01";
    private SHPriestParser parser = new SHPriestParser();

    @Override
    public void load() {

    }

    @Override
    public ResultActions update(RawScreenData data) {
        SHPriestPlayerData player = parser.parseData(data);
        if(player == null) return ResultActions.noAction();
        logComData(data,player);
        if (!player.isActive()) {
            return ResultActions.noAction("Neni aktivni");
        }
        if (!player.getCasting().equals(CastType.NONE) && player.getCastingTimeRemaining() > 0.3) {
            return ResultActions.noAction("Casti");
        }

        if(player.getPowerWordShield().isCastable()) return  ResultActions.action(KeyPress.pressKey(POWER_WORD_SHIELD_KEY));
        if(player.getVampiricTouch().isCastable()) return  ResultActions.action(KeyPress.pressKey(VAMPIRIC_TOUCH_KEY));
        if(player.getShadowWordPain().isCastable()) return  ResultActions.action(KeyPress.pressKey(SHADOW_WORD_PAIN_KEY));
        if(player.getVampiricEmbrace().isCastable()) return  ResultActions.action(KeyPress.pressKey(VAMPIRIC_EMBRACE_KEY));
        if(player.getMindBlast().isCastable()) return  ResultActions.action(KeyPress.pressKey(MIND_BLAST_KEY));
        if(player.getMindFly().isCastable()) return  ResultActions.action(KeyPress.pressKey(MIND_FLAY_KEY));
        return ResultActions.noAction("Neni co delat");
    }

    @Override
    public void unload() {

    }
}
