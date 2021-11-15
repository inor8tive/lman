package innovative.bots.lman.services.impl;

import innovative.bots.lman.configurations.BHTConfigurations;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SynonymsServiceImplTests {
    @InjectMocks
    SynonymsServiceImpl synonymsService;

    @Mock
    BHTConfigurations apiConfig;

    @Mock
    RestTemplate restTemplate;

    @Test
    void get_synonyms_returns_list_of_synonyms_of_given_word() {
        ResponseEntity<String> response = ResponseEntity.ok().body("is it not okay");

        when(apiConfig.getHost()).thenReturn("https://www.google.com");
        when(apiConfig.getKey()).thenReturn("key");
        when(restTemplate.getForEntity(anyString(), eq(String.class))).thenReturn(response);

        List<String> synonyms = synonymsService.getSynonymsOf("expect");

        assertEquals(4, synonyms.size());
    }
}
