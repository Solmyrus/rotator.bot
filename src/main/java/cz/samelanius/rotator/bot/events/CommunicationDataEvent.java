package cz.samelanius.rotator.bot.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommunicationDataEvent {
    private String debugMessage1;
    private String debugMessage2;
}
