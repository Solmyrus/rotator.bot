package cz.samelanius.rotator.bot.core.classpackages.classes.shadowPriest;

import cz.samelanius.rotator.bot.core.ThreatTools;
import cz.samelanius.rotator.bot.core.classpackages.AbstractClassPackage;
import cz.samelanius.rotator.bot.core.classpackages.CastType;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.engine.ResultAction;

import static cz.samelanius.rotator.bot.core.classpackages.classes.shadowPriest.SHPriestKeybindigs.*;

public class SHPriestPackage extends AbstractClassPackage {

    public static final String PACKAGE_ID = "sh_01";
    private SHPriestParser parser = new SHPriestParser();

    @Override
    public void load() {

    }

    @Override
    public ResultAction update(RawScreenData data) {
        SHPriestPlayerData player = parser.parseData(data);
        if(player == null) return ResultAction.noAction();
        logComData(data,player);
        if (!player.isActive()) {
            return ResultAction.noAction("Neni aktivni");
        }
        if (!player.getCasting().equals(CastType.NONE) && player.getCastingTimeRemaining() > 0.3) {
            return ResultAction.noAction("Casti");
        }

        if(player.getVampiricTouch().isCastable()) return ResultAction.keyPress(VAMPIRIC_TOUCH_KEY);
        if(player.getShadowWordPain().isCastable()) return ResultAction.keyPress(SHADOW_WORD_PAIN_KEY);
        if(player.getVampiricEmbrace().isCastable()) return ResultAction.keyPress(VAMPIRIC_EMBRACE_KEY);
        if(player.getMindBlast().isCastable()) return ResultAction.keyPress(MIND_BLAST_KEY);
        if(player.getMindFly().isCastable()) return ResultAction.keyPress(MIND_FLAY_KEY);
        return ResultAction.noAction("Neni co delat");
    }

    @Override
    public void unload() {

    }
}
