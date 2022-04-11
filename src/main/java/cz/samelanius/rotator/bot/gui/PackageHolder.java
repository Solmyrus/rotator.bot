package cz.samelanius.rotator.bot.gui;

import cz.samelanius.rotator.bot.core.class_packages.classes.baladruid.BalancedDruidPackage;
import cz.samelanius.rotator.bot.core.class_packages.classes.protwar.ProtWarPackage;
import lombok.Getter;

public class PackageHolder {
    @Getter
    private BalancedDruidPackage balancedDruidPackage = new BalancedDruidPackage();

    @Getter
    private ProtWarPackage protWarPackage = new ProtWarPackage();
}
