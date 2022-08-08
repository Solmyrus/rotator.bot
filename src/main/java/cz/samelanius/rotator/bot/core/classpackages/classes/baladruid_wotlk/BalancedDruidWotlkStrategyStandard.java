package cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk;

import cz.samelanius.rotator.bot.core.engine.ResultAction;

import static cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk.BalancedDruidWotlkCasts.*;

public class BalancedDruidWotlkStrategyStandard implements BalancedDruidWotlkStrategy {

    private static final long CAST_CD = 300;

    private long lastCast = 0L;
    private EclipseMode eclipseMode = EclipseMode.SOLAR;

    @Override
    public ResultAction update(BalancedDruidWotlkPlayerData player) {
        if (player.isActivateManaPotion()) return castSpell(MANA_POTION);
        if (player.isActivateDarkRune()) return castSpell(DARK_RUNE);
        if (player.isActivateTrinket()) return castSpell(TRINKET);
        if (player.isActivateInnervate()) return castSpell(INNERVATE);
        if (player.isActivateDestructionPotion()) return castSpell(DESTRUCTION_POTION);

        if(player.getSpellFaerieFire().isCastable()) return castSpell(FAERIE_FIRE);

        if(!player.isLunarEclipseAura() && !player.isSolarEclipseAura()) {
            if(player.getSpellMoonFire().isCastable()) return castSpell(MOON_FIRE);
            if(player.getSpellInsectSwarm().isCastable()) return castSpell(INSECT_SWARM);
            if(player.getSpellStarFall().isCastable()) return castSpell(STAR_FALL);
        }

        if(player.isLunarEclipseAura()) eclipseMode = EclipseMode.LUNAR;
        if(player.isSolarEclipseAura()) eclipseMode = EclipseMode.SOLAR;

        if(eclipseMode.equals(EclipseMode.SOLAR)) {
            if(player.getWrath().isCastable()) return castSpell(WRATH);
        } else {
            if(player.getSpellStarFire().isCastable()) return castSpell(STAR_FIRE);
        }

        return ResultAction.noAction("Neni co delat");
    }

    private ResultAction castSpell(BalancedDruidWotlkCasts cast) {

        if(System.currentTimeMillis() - CAST_CD < lastCast) {
            return ResultAction.noAction("CastCD");
        }

        System.out.println("Castim: " + cast);
        lastCast = System.currentTimeMillis();
        if(cast.getModifier() == null) return ResultAction.keyPress(cast.getKey());
        else return ResultAction.keyPress(cast.getKey(), cast.getModifier());
    }


}
