package innovative.bots.lman.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("utilities.bht-api")
@Data
@Component
public class BHTConfigurations {
    private String host;
    private String key;
}
