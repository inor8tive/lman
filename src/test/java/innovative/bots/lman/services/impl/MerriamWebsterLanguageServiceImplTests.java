package innovative.bots.lman.services.impl;

import innovative.bots.lman.configurations.MerriamWebsterConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MerriamWebsterLanguageServiceImplTests {
    @InjectMocks
    MerriamWebsterLanguageServiceImpl languageService;
    @Mock
    RestTemplate restTemplate;
    @Mock
    MerriamWebsterConfig config;
    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    void get_synonyms_returns_list_of_strings() {
        String stringResponse = "[]";
        ResponseEntity<String> response = ResponseEntity.ok().body(stringResponse);

        when(config.getHost()).thenReturn("https://www.dictionaryapi.com/api/v3/references/thesaurus/json");
        when(config.getKey()).thenReturn("your-api-key");
        when(restTemplate.getForEntity(stringArgumentCaptor.capture(), eq(String.class)))
                .thenReturn(response);
        List<String> syn = languageService.getSynonyms("goat");


        assertEquals("https://www.dictionaryapi.com/api/v3/references/thesaurus/json/goat?key=your-api-key",
                stringArgumentCaptor.getValue());
        assertEquals(0, syn.size());
    }

    @Test
    void get_antonyms_returns_list_of_strings() {
        String stringResponse = "[]";
        ResponseEntity<String> response = ResponseEntity.ok().body(stringResponse);

        when(config.getHost()).thenReturn("https://www.dictionaryapi.com/api/v3/references/thesaurus/json");
        when(config.getKey()).thenReturn("your-api-key");
        when(restTemplate.getForEntity(stringArgumentCaptor.capture(), eq(String.class)))
                .thenReturn(response);
        List<String> syn = languageService.getAntonyms("goat");

        assertEquals("https://www.dictionaryapi.com/api/v3/references/thesaurus/json/goat?key=your-api-key",
                stringArgumentCaptor.getValue());
        assertEquals(0, syn.size());
    }
}
