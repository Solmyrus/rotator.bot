package cz.samelanius.rotator.bot.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogMessage {
    private MessageLevel level;
    private String message;
}
