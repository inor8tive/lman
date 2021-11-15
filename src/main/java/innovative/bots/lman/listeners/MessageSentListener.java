package innovative.bots.lman.listeners;

import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MessageSentListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        super.onMessageReceived(event);
        if(event.getAuthor().isBot()) {
            event.getMessage()
                    .delete()
                    .completeAfter(5, TimeUnit.SECONDS);

            log.info("Message from {} deleted", event.getAuthor().getName());
        }
    }
}
