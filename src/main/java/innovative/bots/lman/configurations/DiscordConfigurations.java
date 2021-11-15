package innovative.bots.lman.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("discord.bot")
@Component
@Data
public class DiscordConfigurations {
    private String token;
}
