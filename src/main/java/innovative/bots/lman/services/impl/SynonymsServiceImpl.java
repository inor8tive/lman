package innovative.bots.lman.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import innovative.bots.lman.configurations.BHTConfigurations;
import innovative.bots.lman.models.BHTResponse;
import innovative.bots.lman.services.SynonymsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SynonymsServiceImpl implements SynonymsService {
    private final String RETURN_TYPE= "json";

    private final BHTConfigurations apiConfig;
    private final RestTemplate restTemplate;

    @Override
    public List<String> getSynonymsOf(String word) {
        String host = apiConfig.getHost();
        String key = apiConfig.getKey();
        String url = String.format("%s/%s/%s/%s", host, key, word, RETURN_TYPE);

       BHTResponse response =  fetch( url);
        return response.getAntonyms();
    }

    private BHTResponse fetch(String url) {
        log.info(url);

        ResponseEntity<String> response =  restTemplate.getForEntity(url, String.class);


       if (response.getStatusCode().is2xxSuccessful()) {
           log.info(response.getBody());
           return  new BHTResponse(response.getBody());
       }

        return new BHTResponse(response.getBody());
    }
}
