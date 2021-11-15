package innovative.bots.lman.services;

import java.util.List;

public interface LanguageService {
    List<String> getSynonyms(String word);
    List<String> getAntonyms(String word);
}
