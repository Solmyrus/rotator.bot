package cz.samelanius.rotator.bot.core.engine;

import com.google.common.eventbus.EventBus;
import cz.samelanius.rotator.bot.core.classpackages.ClassPackage;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.communication.screenparsing.ScreenController;
import cz.samelanius.rotator.bot.events.EventBusHolder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CoreEngine {

    private ScreenController screenController = new ScreenController();
    private static final long UPDATE_DIFF = 100;
    private boolean run;

    private EventBus eventBus = EventBusHolder.getEventBus();

    public CoreEngine() {
        eventBus.register(this);
    }


    public void start(ClassPackage classPackage) {

        screenController.init(300,1);

        System.out.println("Starturji");
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        run = true;

        classPackage.load();

        executorService.scheduleWithFixedDelay(
                () -> {
                    if(!run) {
                        executorService.shutdown();
                        System.out.println("Ukoncuji vlakno");
                        classPackage.unload();
                    }

                    try {
                        RawScreenData data = screenController.readData();
                        ResultAction result = classPackage.update(data);

                        switch (result.getType()) {
                            case WAIT_ACTION:
                                break;
                            case KEY_PRESS_ACTION:
                                screenController.pressAndReleaseKey(result.getKeyCode(), result.getModificatorKeyCode());
                                break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }, 0, UPDATE_DIFF, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        run = false;
    }

    public boolean isRunning() {
        return run;
    }

}
