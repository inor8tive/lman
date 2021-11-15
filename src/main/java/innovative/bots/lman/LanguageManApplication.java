package innovative.bots.lman;

import innovative.bots.lman.services.impl.DiscordBotManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class LanguageManApplication {
    @Autowired
    DiscordBotManagementService botService;

    public static void main(String[] args) {
        SpringApplication.run(LanguageManApplication.class, args);
    }

    @PostConstruct
    void listenForMessages() {
        botService.init();
    }


    @Bean
    RestTemplate configRestTemplate() {
        RestTemplateBuilder builder = new RestTemplateBuilder();
        return builder.build();
    }

}
