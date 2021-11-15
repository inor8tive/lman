package innovative.bots.lman.services.impl;

import innovative.bots.lman.services.MessageBuilderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MessageBuilderServiceImpl implements MessageBuilderService {
    @Override
    public String buildStringList(List<String> synonyms, String title) {
        String message = String.format("\n%s\n\n %s", title, String.join(" || ", synonyms));
        log.info("{}", message.length());

        return message;
    }
}
