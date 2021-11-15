package innovative.bots.lman.listeners;

import innovative.bots.lman.services.LanguageService;
import innovative.bots.lman.services.MessageBuilderService;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.InteractionHook;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.requests.RestAction;
import net.dv8tion.jda.api.requests.restaction.WebhookMessageAction;
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
public class AntonymSlashListenerTest {
    @InjectMocks
    AntonymsSlashCommandListener listener;

    @Mock
    LanguageService languageService;
    @Mock
    private MessageBuilderService messageBuilderService;

    @Test
    void on_slash_only_uses_word_if_only_single_word_provided() {
        ReplyAction mockAction = mock(ReplyAction.class);
        InteractionHook mockInteractionHook = mock(InteractionHook.class);
        WebhookMessageAction<Message> mockWebhook  = mock(WebhookMessageAction.class);
        SlashCommandEvent mockSlashCommand = mock(SlashCommandEvent.class);
        OptionMapping mockOption = mock(OptionMapping.class);

        when(mockOption.getAsString()).thenReturn("energy");
        when(mockInteractionHook.sendMessage("message")).thenReturn(mockWebhook);
        when(mockSlashCommand.getHook()).thenReturn(mockInteractionHook);
        when(mockSlashCommand.deferReply()).thenReturn(mockAction);
        when(mockSlashCommand.getName()).thenReturn("antonyms");
        when(mockSlashCommand.getOption("word")).thenReturn(mockOption);


        List<String> ss = Arrays.asList("dog", "another", "related");

        when(languageService.getAntonyms("energy")).thenReturn(ss);
        when(messageBuilderService.buildStringList(ss, "Antonyms of the word 'ENERGY'")).thenReturn("message");
        listener.onSlashCommand(mockSlashCommand);
    }

    @Test
    void on_slash_sends_message_of_antonyms() {
        ReplyAction mockAction = mock(ReplyAction.class);
        InteractionHook mockInteractionHook = mock(InteractionHook.class);
        WebhookMessageAction<Message> mockWebhook  = mock(WebhookMessageAction.class);
        SlashCommandEvent mockSlashCommand = mock(SlashCommandEvent.class);
        OptionMapping mockOption = mock(OptionMapping.class);

        when(mockOption.getAsString()).thenReturn("dog");
        when(mockInteractionHook.sendMessage("message")).thenReturn(mockWebhook);
        when(mockSlashCommand.getHook()).thenReturn(mockInteractionHook);
        when(mockSlashCommand.deferReply()).thenReturn(mockAction);
        when(mockSlashCommand.getName()).thenReturn("antonyms");
        when(mockSlashCommand.getOption("word")).thenReturn(mockOption);


        List<String> ss = Arrays.asList("dog", "another", "related");

        when(languageService.getAntonyms("dog")).thenReturn(ss);
        when(messageBuilderService.buildStringList(ss, "Antonyms of the word 'DOG'")).thenReturn("message");
        listener.onSlashCommand(mockSlashCommand);
    }

    @Test
    void on_slash_deletes_message_if_no_parameter_is_specified() {
        ReplyAction mockAction = mock(ReplyAction.class);
        InteractionHook mockInteractionHook = mock(InteractionHook.class);
        SlashCommandEvent mockSlashCommand = mock(SlashCommandEvent.class);
        RestAction<Void> mockRestAction = mock(RestAction.class);

        when(mockInteractionHook.deleteOriginal()).thenReturn(mockRestAction);
        when(mockSlashCommand.getHook()).thenReturn(mockInteractionHook);
        when(mockSlashCommand.deferReply()).thenReturn(mockAction);
        when(mockSlashCommand.getName()).thenReturn("antonyms");

        List<String> ss = Arrays.asList("dog", "another", "related");

        listener.onSlashCommand(mockSlashCommand);
    }
}
