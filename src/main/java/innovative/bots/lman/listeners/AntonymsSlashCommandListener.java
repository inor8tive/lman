package innovative.bots.lman.listeners;

import innovative.bots.lman.constants.Commands;
import innovative.bots.lman.utils.StringManipulationUtility;
import lombok.RequiredArgsConstructor;
import innovative.bots.lman.services.LanguageService;
import innovative.bots.lman.services.MessageBuilderService;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class AntonymsSlashCommandListener extends ListenerAdapter {
    private final LanguageService languageService;
    private final MessageBuilderService messageBuilderService;

    @Override
    public void onSlashCommand(@Nonnull SlashCommandEvent event) {
        if (event.getName().equals(Commands.ANTONYMS.name)) {
            event.deferReply().queue();

            OptionMapping wordOption = event.getOption("word");

            if(wordOption != null) {
                String targetWord = wordOption.getAsString();
                String title = String.format("Antonyms of the word '%s'", targetWord.toUpperCase());
                List<String> synonyms = languageService.getAntonyms(targetWord);
                String message = messageBuilderService.buildStringList(synonyms, title);

                //reply
                event.getHook().sendMessage(message).complete();
            } else {
                event.getHook().deleteOriginal().complete();
            }
        }
    }
}
