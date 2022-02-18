package seoul.globalAdManagerPlatformByMtak.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seoul.globalAdManagerPlatformByMtak.dto.AdOwnerSaveRequestDto;
import seoul.globalAdManagerPlatformByMtak.service.AdService;

@RestController
@RequiredArgsConstructor
public class OwnerController {

    private final AdService adService;

    @PostMapping("/sign-in")
    public Long save(@RequestBody AdOwnerSaveRequestDto adOwnerSaveRequestDto) {
        return adService.ownerSave(adOwnerSaveRequestDto);
    }
}
