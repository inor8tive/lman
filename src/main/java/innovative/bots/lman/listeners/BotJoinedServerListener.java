package innovative.bots.lman.listeners;

import innovative.bots.lman.constants.Commands;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;

import javax.annotation.Nonnull;

@Slf4j
public class BotJoinedServerListener extends ListenerAdapter {
    @Override
    public void onGuildJoin(@Nonnull GuildJoinEvent event) {
        JDA jda = event.getJDA();

        //register synonyms
        jda.upsertCommand(Commands.SYNONYMS.name, Commands.SYNONYMS.description)
                .addOption(OptionType.STRING, "word", "word to get its synonyms")
                .setDefaultEnabled(true).queue();
        jda.upsertCommand(Commands.ANTONYMS.name, Commands.ANTONYMS.description)
                .addOption(OptionType.STRING, "word", "word to get its antonyms")
                .setDefaultEnabled(true).queue();
        String server = event.getGuild().getName();

        log.info("I just Joined and Created 'synonyms' and 'antonyms' commands on '{}' server", server.toUpperCase());
    }
}
