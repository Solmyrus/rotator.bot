package cz.samelanius.rotator.bot.core.classpackages.playerStructure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.samelanius.rotator.bot.core.classpackages.BasePlayerRawData;
import cz.samelanius.rotator.bot.core.classpackages.classes.baladruid.BalancedDruidPlayerData;
import cz.samelanius.rotator.bot.core.communication.screenparsing.RawScreenData;

public class PlayerParser {
    protected ObjectMapper objectMapper = new ObjectMapper();


    protected  <T> T parseFromJson(RawScreenData data, Class<T> valueType) {
        try {
            return objectMapper.readValue(data.getRawData(), valueType);
        } catch (JsonProcessingException e) {
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

        playerData.getRage().setValue(data.getRage());
        playerData.getRage().setMaxValue(data.getMaxRage());

        playerData.getEnergy().setValue(data.getEnergy());
        playerData.getEnergy().setMaxValue(data.getMaxEnergy());


        playerData.getEnergy().setValue(0);
        playerData.getEnergy().setMaxValue(100);

        playerData.getRage().setValue(0);
        playerData.getRage().setMaxValue(100);

        playerData.setTargetHealth(data.getTargetHealth());
        playerData.setTargetName(data.getTargetName());



        return playerData;
    }

}
