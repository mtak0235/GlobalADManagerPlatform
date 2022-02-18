package seoul.globalAdManagerPlatformByMtak.controller;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import seoul.globalAdManagerPlatformByMtak.domain.AdOwner;
import seoul.globalAdManagerPlatformByMtak.domain.AdOwnerRepository;
import seoul.globalAdManagerPlatformByMtak.dto.AdOwnerSaveRequestDto;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OwnerControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private AdOwnerRepository adOwnerRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @After
    public void tearDown() throws Exception{
        adOwnerRepository.deleteAll();
    }

    @Test
    void save() {
        String nick = "name";
        AdOwnerSaveRequestDto requestDto = AdOwnerSaveRequestDto.builder()
                .nickname(nick)
                .build();
        String url = "http://localhost:" + port + "/sign-in";
        ResponseEntity<Long> response = restTemplate.postForEntity(url, requestDto, Long.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isGreaterThan(0L);
        List<AdOwner> all = adOwnerRepository.findAll();
        assertThat(all.get(0).getNickname()).isEqualTo(nick);

    }
}