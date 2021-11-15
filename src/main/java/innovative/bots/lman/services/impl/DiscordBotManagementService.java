package innovative.bots.lman.services.impl;

import innovative.bots.lman.configurations.DiscordConfigurations;
import innovative.bots.lman.listeners.AntonymsSlashCommandListener;
import innovative.bots.lman.listeners.BotJoinedServerListener;
import innovative.bots.lman.listeners.MessageSentListener;
import innovative.bots.lman.listeners.SynonymsSlashCommandListener;
import innovative.bots.lman.services.LanguageService;
import innovative.bots.lman.services.MessageBuilderService;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
@RequiredArgsConstructor
public class DiscordBotManagementService {
    private final DiscordConfigurations configurations;
    private final LanguageService languageService;
    private final MessageBuilderService messageBuilderService;

    public JDA connect() {
        try {
            return JDABuilder.createDefault(configurations.getToken()).build();
        } catch (LoginException exception) {
            exception.printStackTrace();
            throw new RuntimeException("Unable to Login");
        }
    }

    public void init() {
        JDA jda = this.connect();
        // register all listeners
        jda.addEventListener(new MessageSentListener());
        jda.addEventListener(new SynonymsSlashCommandListener(languageService, messageBuilderService));
        jda.addEventListener(new AntonymsSlashCommandListener(languageService, messageBuilderService));
        jda.addEventListener(new BotJoinedServerListener());
    }
}
