package innovative.bots.lman.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import innovative.bots.lman.configurations.MerriamWebsterConfig;
import innovative.bots.lman.services.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import innovative.bots.lman.models.MWResponse;
import innovative.bots.lman.models.WResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MerriamWebsterLanguageServiceImpl implements LanguageService {
    private final String KEY_DESC= "key";

    private final MerriamWebsterConfig websterConfig;
    private final RestTemplate restTemplate;

    @Override
    public List<String> getSynonyms(String word) {
        String url = generateUrl(word);
        return fetch(url).getSynonyms();
    }

    @Override
    public List<String> getAntonyms(String word) {
        String url = generateUrl(word);
        return fetch(url).getAntonyms();
    }


    private String generateUrl(String word) {
        return String.format("%s/%s?%s=%s", websterConfig.getHost(), word, KEY_DESC, websterConfig.getKey());
    }
    private MWResponse fetch(String url) {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if(response.getStatusCode().is2xxSuccessful()) {
            String r = response.getBody();
            try {
                List<WResponseEntity> p = new ObjectMapper().readValue(r, new TypeReference<List<WResponseEntity>>() {});
                return new MWResponse(p);
            } catch (JsonProcessingException e) {
                log.error(e.getMessage());
            }
        } else {
            log.error("COULD NOT GET RESPONSE");
        }
        return new MWResponse();
    }
}
