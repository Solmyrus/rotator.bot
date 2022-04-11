package cz.samelanius.rotator.bot.events;

import com.google.common.eventbus.EventBus;
public class EventBusHolder {
    private static EventBus instance = null;
    private EventBusHolder() {

    }

    public static EventBus getEventBus() {
        if(instance == null) instance = new EventBus();
        return instance;
    }
}
