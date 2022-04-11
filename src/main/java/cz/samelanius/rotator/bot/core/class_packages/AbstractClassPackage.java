package cz.samelanius.rotator.bot.core.class_packages;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.EventBus;
import cz.samelanius.rotator.bot.core.class_packages.classes.baladruid.BalancedDruidPlayerData;
import cz.samelanius.rotator.bot.core.class_packages.playerStructure.PlayerData;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;
import cz.samelanius.rotator.bot.events.CommunicationDataEvent;
import cz.samelanius.rotator.bot.events.EventBusHolder;

public abstract class AbstractClassPackage implements ClassPackage {
    private ObjectMapper mapper = new ObjectMapper();

    private EventBus eventBus = EventBusHolder.getEventBus();

    protected void logComData(RawScreenData data, PlayerData player) {
        try {
            eventBus.post(new CommunicationDataEvent(
                    mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper.readTree(data.getRawData())),
                    mapper.writerWithDefaultPrettyPrinter().writeValueAsString(player)));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
