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
        playerData.setCastingTimeRemaining(data.getCastingTimeRemaining());
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


        playerData.getEnergy().setValue(data.getEnergy());
        playerData.getEnergy().setMaxValue(100);

        playerData.getRage().setValue(data.getRage());
        playerData.getRage().setMaxValue(100);

        playerData.getTarget().setTargetHealth(data.getTargetHealth());
        playerData.getTarget().setTargetName(data.getTargetName());

        playerData.getTarget().setTankingStatus(getTankingStatus(data.getTankingStatus()));
        playerData.getTarget().setThreatValue(data.getThreatValue()/100);
        playerData.getTarget().setThreatRawPercentage(data.getThreatRawPercentage());
        playerData.getTarget().setThreatScaledPercentage(data.getThreatScaledPercentage());
        playerData.getTarget().setTanking(data.isTanking());

        if(playerData.getTarget().getThreatRawPercentage() > 0) {
            playerData.getTarget().setThreatTank(playerData.getTarget().getThreatValue() / playerData.getTarget().getThreatRawPercentage() * 100);
            playerData.getTarget().setThreatDiff(playerData.getTarget().getThreatTank() - playerData.getTarget().getThreatValue());
        }

        return playerData;
    }

    private TankingStatus getTankingStatus(int tankingStatus) {
        switch (tankingStatus) {
            case 0: return TankingStatus.NOT_TANKING_LOW_THREAT;
            case 1: return TankingStatus.NOT_TANKING_HIGH_THREAT;
            case 2: return TankingStatus.TANKING_INSECURE;
            case 3: return TankingStatus.TANKING_SECURE;
        }
        return null;
    }

}
