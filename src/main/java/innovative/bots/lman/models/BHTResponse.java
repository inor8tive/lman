package innovative.bots.lman.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class BHTResponse {
    String value;

    public List<String> getAntonyms() {
        return Arrays.asList(value.split(" "));
    }
}
