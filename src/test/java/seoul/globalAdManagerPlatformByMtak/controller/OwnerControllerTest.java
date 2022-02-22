package seoul.globalAdManagerPlatformByMtak.controller;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import seoul.globalAdManagerPlatformByMtak.domain.*;
import seoul.globalAdManagerPlatformByMtak.dto.AdOwnerSaveRequestDto;
import seoul.globalAdManagerPlatformByMtak.dto.AdSaveRequestDto;
import seoul.globalAdManagerPlatformByMtak.dto.AdUpdateRequestDto;

import java.util.ArrayList;
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
    private AdRepository adRepository;


    @Autowired
    private TestRestTemplate restTemplate;

    @After
    public void tearDown() throws Exception{
        adOwnerRepository.deleteAll();
    }

    @Test
    void 회원가입() {
        String nick = "mtak";
        AdOwnerSaveRequestDto requestDto = AdOwnerSaveRequestDto.builder()
                .nickname(nick)
                .build();
        String url = "http://localhost:" + port + "/sign-up";
        ResponseEntity<Long> response = restTemplate.postForEntity(url, requestDto, Long.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isGreaterThan(0L);
        List<AdOwner> all = adOwnerRepository.findAll();
        assertThat(all.get(0).getNickname()).isEqualTo(nick);
    }

    @Test
    void 광고등록() {
        String title = "welcome to neverland";
        String content = "open 9 a.m by room 202";

        String nick = "mtak";

        String url = "https://www.youtube.com/watch?v=EZntLk9bTUw";
        AdSaveRequestDto adSaveRequestDto = AdSaveRequestDto.builder()
                .title(title)
                .content(content)
                .url(url)
                .adOwner(nick)
                .build();
        String addr = "http://localhost:" + port + "/ad";

        ResponseEntity<Long> response = restTemplate.postForEntity(addr, adSaveRequestDto, Long.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<Ad> all = adRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
    }

    @Test
    public void 광고수정() {
        List<AdImg> images = new ArrayList<AdImg>();
        String nick = "mtak";
        AdOwner adOwner = AdOwner.builder()
                .nickname(nick)
                .build();
        String addr = "https://www.youtube.com/watch?v=EZntLk9bTUw";
        Ad savedAd = adRepository.save(Ad.builder()
                .title("delicious meal")
                .content("big event")
                .url(addr)
                .owner(adOwner)
                .build()
        );
        Long updateId = savedAd.getId();
        String expectedTitle = "awful meal";
        String expectedContent = "small event";
        AdUpdateRequestDto requestDto = AdUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .url(addr)
                .images(images)
                .adOwner(adOwner)
                .build();
        String url = "http://localhost:" + port + "/ad/" + updateId;
        HttpEntity<AdUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);
        ResponseEntity<Long> responseEntity = restTemplate
                .exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);
        List<Ad> all = adRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    }

    @Test
    void 광고삭제() {

    }

}