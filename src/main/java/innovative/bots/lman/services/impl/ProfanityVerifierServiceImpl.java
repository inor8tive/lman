package innovative.bots.lman.services.impl;

import innovative.bots.lman.services.ProfanityVerifierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProfanityVerifierServiceImpl implements ProfanityVerifierService {
    @Override
    public boolean isSafe(String word) {
        return true;
    }
}
