package innovative.bots.lman.services;

import java.util.List;

public interface MessageBuilderService {
    String buildStringList(List<String> synonyms, String targetWord);
}
