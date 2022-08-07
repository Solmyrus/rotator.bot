package cz.samelanius.rotator.bot.core.classpackages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimplePackageRawData {
    @JsonProperty("profile")
    private String profile;
}
