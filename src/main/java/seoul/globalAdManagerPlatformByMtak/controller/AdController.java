package seoul.globalAdManagerPlatformByMtak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seoul.globalAdManagerPlatformByMtak.dto.AdSaveRequestDto;
import seoul.globalAdManagerPlatformByMtak.service.AdService;

@RestController
@RequiredArgsConstructor
public class AdController {
    private final AdService adService;

    @PostMapping("/save-ad")
    public Long save(@RequestBody AdSaveRequestDto requestDto) {
        return adService.adSave(requestDto);
    }
}
