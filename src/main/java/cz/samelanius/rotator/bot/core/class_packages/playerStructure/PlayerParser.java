package cz.samelanius.rotator.bot.core.class_packages.playerStructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.samelanius.rotator.bot.core.class_packages.BasePlayerRawData;
import cz.samelanius.rotator.bot.core.class_packages.CastType;
import cz.samelanius.rotator.bot.core.class_packages.classes.baladruid.BalancedDruidPlayerData;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;

public class PlayerParser {
    protected ObjectMapper objectMapper = new ObjectMapper();


    protected  <T> T parseFromJson(RawScreenData data, Class<T> valueType) {
        try {
            return objectMapper.readValue(data.getRawData(), valueType);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("Nenaparsovano");
        }
        return null;
    }

    public PlayerData parseBaseData(BasePlayerRawData data) {
        return parseBaseData(data, new BalancedDruidPlayerData());
    }

    public PlayerData parseBaseData(BasePlayerRawData data, PlayerData playerData) {
        playerData.setActive(data.isActive());
        playerData.setCasting(data.getCasting());
        playerData.setRunning(data.isRunning());
        playerData.setPotionCD(data.isPotionCD());

        playerData.getHealth().setValue(data.getHealth());
        playerData.getHealth().setMaxValue(data.getMaxHealth());

        playerData.getMana().setValue(data.getMana());
        playerData.getMana().setMaxValue(data.getMaxMana());

        playerData.getEnergy().setValue(0);
        playerData.getEnergy().setMaxValue(100);

        playerData.getRage().setValue(0);
        playerData.getRage().setMaxValue(100);

        return playerData;
    }

}
