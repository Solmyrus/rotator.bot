package cz.samelanius.rotator.bot.core.engine;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.EventBus;
import cz.samelanius.rotator.bot.core.classpackages.ClassPackage;
import cz.samelanius.rotator.bot.core.classpackages.SimplePackageRawData;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.core.communication.screenparsing.ScreenController;
import cz.samelanius.rotator.bot.core.engine.actions.ResultAction;
import cz.samelanius.rotator.bot.core.engine.actions.ResultActions;
import cz.samelanius.rotator.bot.events.EventBusHolder;
import cz.samelanius.rotator.bot.gui.PackageHolder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CoreEngine {

    private ObjectMapper mapper = new ObjectMapper();

    private ScreenController screenController = new ScreenController();

    private static final long UPDATE_DIFF = 100; //TODO

    private boolean run;

    private EventBus eventBus = EventBusHolder.getEventBus();

    private ClassPackage classPackage;

    private ScheduledExecutorService executorService;

    private PackageHolder packageHolder = new PackageHolder();


    public CoreEngine() {
        eventBus.register(this);
    }

    public void start() {
        loadPackage();
        startCore();
        coreLoop();
    }

    private void coreLoop() {
        executorService = Executors.newScheduledThreadPool(1);

        executorService.scheduleWithFixedDelay(
                () -> {
                    if (!run) stopCore();

                    RawScreenData data = screenController.readData();
                    ResultActions result = classPackage.update(data);
                    processResult(result);

                }, 0, UPDATE_DIFF, TimeUnit.MILLISECONDS);
    }

    private void processResult(ResultActions result) {
        result.apply(screenController);
    }

    private void stopCore() {
        executorService.shutdown();
        classPackage.unload();
    }

    private void startCore() {
        run = true;
        classPackage.load();
    }

    private void loadPackage() {
        screenController.init(300, 1); //TODO

        RawScreenData data = screenController.readData();

        try {
            System.out.println(data.getRawData());
            SimplePackageRawData packageData = mapper.readValue(data.getRawData(), SimplePackageRawData.class);
            System.out.println("XXX: " + packageData.getProfile());
            classPackage = packageHolder.getPackage(packageData.getProfile());
            System.out.println(classPackage);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        run = false;
    }

    public boolean isRunning() {
        return run;
    }

}
