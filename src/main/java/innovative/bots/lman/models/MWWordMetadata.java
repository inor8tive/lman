package innovative.bots.lman.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MWWordMetadata {
    private String id;
    private UUID uuid;
    private boolean offensive;
    private List<List<String>> syns;
    private List<List<String>> ants;
}
