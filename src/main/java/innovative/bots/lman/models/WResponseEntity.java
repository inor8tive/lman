package innovative.bots.lman.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WResponseEntity {
    private MWWordMetadata meta;
}
