package cz.samelanius.rotator.bot.events;

import lombok.Getter;

public enum MessageLevel {
    ERROR(1,"<ERROR>"),
    INFO(2,"<INFO>"),
    DEBUG(3,"<DEBUG>"),
    TRACE(4,"<TRACE>");

    @Getter
    private int level;

    @Getter
    private String prefix;

    MessageLevel(int level, String prefix) {
        this.level = level;
        this.prefix = prefix;
    }
}
