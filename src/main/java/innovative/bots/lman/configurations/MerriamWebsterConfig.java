package innovative.bots.lman.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("utilities.merriam-webster")
public class MerriamWebsterConfig {
    private String host;
    private String key;
}
