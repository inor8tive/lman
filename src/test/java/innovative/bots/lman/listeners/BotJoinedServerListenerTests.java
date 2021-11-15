package innovative.bots.lman.listeners;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.restaction.CommandCreateAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BotJoinedServerListenerTests {
    @InjectMocks
    BotJoinedServerListener listener;

    @Test
    void on_join_creates_synonyms_command() {
        GuildJoinEvent mockJoinEvent = mock(GuildJoinEvent.class);
        JDA mockJDA = mock(JDA.class);
        CommandCreateAction mockCommandCreationAction = mock(CommandCreateAction.class);
        Guild mockServer = mock(Guild.class);

        when(mockServer.getName()).thenReturn("It is none of your business");
        when(mockCommandCreationAction.addOption(OptionType.STRING, "word", "word to get its synonyms"))
                .thenReturn(mockCommandCreationAction);
        when(mockCommandCreationAction.addOption(OptionType.STRING, "word", "word to get its antonyms"))
                .thenReturn(mockCommandCreationAction);
        when(mockCommandCreationAction.setDefaultEnabled(true)).thenReturn(mockCommandCreationAction);
        when(mockJDA.upsertCommand("synonyms", "Retrieve synonyms of any English word"))
                .thenReturn(mockCommandCreationAction);
        when(mockJDA.upsertCommand("antonyms", "Retrieve opposites of any English word"))
                .thenReturn(mockCommandCreationAction);
        when(mockJoinEvent.getJDA()).thenReturn(mockJDA);
        when(mockJoinEvent.getGuild()).thenReturn(mockServer);

        listener.onGuildJoin(mockJoinEvent);
    }
}
