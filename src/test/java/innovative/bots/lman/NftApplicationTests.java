package innovative.bots.lman;

import innovative.bots.lman.services.impl.DiscordBotManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class NftApplicationTests {
    @MockBean
    DiscordBotManagementService discordBotManagementService;

    @Test
    void contextLoads() {
    }

}
