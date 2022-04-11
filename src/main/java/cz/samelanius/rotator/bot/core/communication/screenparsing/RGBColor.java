package cz.samelanius.rotator.bot.core.communication.screenparsing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RGBColor {
    private int r;
    private int g;
    private int b;

    public boolean isGreen() {
        if(g < 250) return false;
        if(r > 5) return false;
        if(b > 5) return false;
        return true;
    }

    public boolean isBlue() {
        if(b < 250) return false;
        if(r > 5) return false;
        if(g > 5) return false;
        return true;
    }

    public boolean isRed() {
        if(r < 250) return false;
        if(g > 5) return false;
        if(b > 5) return false;
        return true;
    }

    public boolean isWhite() {
        if(r < 252) return false;
        if(g < 252) return false;
        if(b < 252) return false;
        return true;
    }

    public boolean isYellow() {
        if(r < 252) return false;
        if(g < 252) return false;
        if(b > 5) return false;
        return true;
    }

}
