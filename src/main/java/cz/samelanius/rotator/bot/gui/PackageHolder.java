package cz.samelanius.rotator.bot.gui;

import cz.samelanius.rotator.bot.core.classpackages.ClassPackage;
import cz.samelanius.rotator.bot.core.classpackages.classes.baladruid.BalancedDruidPackage;
import cz.samelanius.rotator.bot.core.classpackages.classes.baladruid_wotlk.BalancedDruidWotlkPackage;
import cz.samelanius.rotator.bot.core.classpackages.classes.feral.FeralDruidPackage;
import cz.samelanius.rotator.bot.core.classpackages.classes.protwar.ProtWarPackage;
import cz.samelanius.rotator.bot.core.classpackages.classes.shadowPriest.SHPriestPackage;

import java.util.HashMap;
import java.util.Map;

public class PackageHolder {

    private Map<String, ClassPackage> packages;

    public PackageHolder() {
        packages = new HashMap<>();
        packages.put(BalancedDruidPackage.PACKAGE_ID, new BalancedDruidPackage());
        packages.put(BalancedDruidWotlkPackage.PACKAGE_ID, new BalancedDruidWotlkPackage());
        packages.put(FeralDruidPackage.PACKAGE_ID, new BalancedDruidPackage());
        packages.put(ProtWarPackage.PACKAGE_ID, new ProtWarPackage());
        packages.put(SHPriestPackage.PACKAGE_ID, new SHPriestPackage());
    }

    public ClassPackage getPackage(String packageId) {
        return packages.get(packageId);
    }

}
