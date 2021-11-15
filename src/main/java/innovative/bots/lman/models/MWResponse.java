package innovative.bots.lman.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MWResponse {
    private List<WResponseEntity> metadata;

    public MWResponse() {
        this.metadata = new ArrayList<>();
    }

    public MWResponse(List<WResponseEntity> value) {
        this.metadata = value;
    }

    public List<String> getSynonyms() {
        return stream(metadata.stream().map(list -> list.getMeta().getSyns()));
    }

    public List<String> getAntonyms() {
        return stream(metadata.stream().map(list -> list.getMeta().getAnts()));
    }

    private List<String> stream(Stream<List<List<String>>> data) {
        return data
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .limit(100)
                .collect(Collectors.toList());
    }
}
