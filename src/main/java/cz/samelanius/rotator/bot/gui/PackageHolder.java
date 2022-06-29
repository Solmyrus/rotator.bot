package cz.samelanius.rotator.bot.gui;

import cz.samelanius.rotator.bot.core.classpackages.classes.baladruid.BalancedDruidPackage;
import cz.samelanius.rotator.bot.core.classpackages.classes.protwar.ProtWarPackage;
import lombok.Getter;

public class PackageHolder {
    @Getter
    private BalancedDruidPackage balancedDruidPackage = new BalancedDruidPackage();

    @Getter
    private ProtWarPackage protWarPackage = new ProtWarPackage();
}
