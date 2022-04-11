package cz.samelanius.rotator.bot.events;

import lombok.Data;

@Data
public class LogMessage {
    private MessageLevel level;
    private String message;
}
