package seoul.globalAdManagerPlatformByMtak.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoul.globalAdManagerPlatformByMtak.domain.AdImgRepository;
import seoul.globalAdManagerPlatformByMtak.domain.AdOwnerRepository;
import seoul.globalAdManagerPlatformByMtak.domain.AdRepository;
import seoul.globalAdManagerPlatformByMtak.dto.AdSaveRequestDto;
import seoul.globalAdManagerPlatformByMtak.dto.AdOwnerSaveRequestDto;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class AdService {

    private final AdImgRepository adImgRepository;
    private final AdOwnerRepository adOwnerRepository;
    private final AdRepository adRepository;

    @Transactional
    public Long ownerSave(AdOwnerSaveRequestDto adOwnerSaveRequestDto) {
        return adOwnerRepository.save(adOwnerSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long adSave(AdSaveRequestDto adSaveRequestDto) {
        return adRepository.save(adSaveRequestDto.toEntity()).getId();
    }
}
