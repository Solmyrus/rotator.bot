package cz.samelanius.rotator.bot.core.classpackages.classes.feral.strategies;

import cz.samelanius.rotator.bot.core.classpackages.classes.feral.DruidForm;
import cz.samelanius.rotator.bot.core.classpackages.classes.feral.FeralDruidPlayerData;
import cz.samelanius.rotator.bot.core.classpackages.classes.feral.FeralDruidStrategy;
import cz.samelanius.rotator.bot.core.engine.actions.KeyPress;
import cz.samelanius.rotator.bot.core.engine.actions.ResultActions;

import static cz.samelanius.rotator.bot.core.classpackages.classes.feral.FeralDruidKeybindigs.*;

public class CatRearStrategy implements FeralDruidStrategy {
    @Override
    public ResultActions update(FeralDruidPlayerData player) {
        if(!player.getForm().equals(DruidForm.CAT)) return ResultActions.noAction();
/*
        System.out.println("---------");


            System.out.println("CP: " + player.getComboPoints() + " ENERGY: " + player.getEnergy());
        System.out.println("RIP: " + player.getRip().isCastable());
        System.out.println("CM: " + player.getCatMangle().isCastable());
        System.out.println("SHRED: " + player.getShred().isCastable());
*/
        if (player.getComboPoints() >= 4 &&
                player.getEnergy().getValue() >= 30 &&
                player.getRip().isCastable())
        {
            System.out.println("Castim RIP");
            return ResultActions.action(KeyPress.pressKey(RIP_KEY).withModificator(MODIFICATOR_KEY));
        }

/*
       if (player.getEnergy().getValue() >= 40 && player.getCatMangle().isCastable()){
           System.out.println("Castim MAGLE");
           return ResultAction.keyPress(CAT_MANGLE_KEY, MODIFICATOR_KEY);
       }
*/


        if (player.getEnergy().getValue() >= 42 && player.getShred().isCastable()) {
            System.out.println("Castim SHRED");
            return ResultActions.action(KeyPress.pressKey(SHRED_KEY).withModificator(MODIFICATOR_KEY));
        }

        if(player.getComboPoints() >= 4 && player.getEnergy().getValue() >= 10) {
            System.out.println("CEKAM NA RIP");
            return ResultActions.noAction();
        }

        if (player.getEnergy().getValue() >= 22) {
            System.out.println("Cekam na SHRED");
            return ResultActions.noAction();
        }



        if(player.getCatForm().isCastable()) {
            System.out.println("Castim POWERSHIFT");
            return ResultActions.action(KeyPress.pressKey(POWERSHIFT_KEY).withModificator(MODIFICATOR_KEY));
        }


        System.out.println("NECASTIM NIC");
        return ResultActions.noAction();

    }
}
