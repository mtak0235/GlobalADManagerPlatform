package seoul.globalAdManagerPlatformByMtak.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seoul.globalAdManagerPlatformByMtak.domain.*;
import seoul.globalAdManagerPlatformByMtak.dto.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdService {

    private final AdImgRepository adImgRepository;
    private final AdOwnerRepository adOwnerRepository;
    private final AdRepository adRepository;
    private final FileHandler fileHandler;

    @Transactional
    public Long ownerSave(AdOwnerSaveRequestDto adOwnerSaveRequestDto) {
        return adOwnerRepository.save(adOwnerSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long adSave(AdSaveRequestDto adSaveRequestDto) throws Exception{
        AdOwner owner = adOwnerRepository.findByNickname(adSaveRequestDto.getAdOwner());
        Ad ad = Ad.builder()
                .title(adSaveRequestDto.getTitle())
                .content(adSaveRequestDto.getContent())
                .url(adSaveRequestDto.getUrl())
                .owner(owner)
                .build();
        List<AdImg> list = fileHandler.parseFileInfo(ad.getId(), adSaveRequestDto.getImages());
        List<AdImg> imgBeans = new ArrayList<>();
        for (AdImg adImg : list) {
            imgBeans.add(adImgRepository.save(adImg));
        }
        ad.setImages(imgBeans);
        return adRepository.save(ad).getId();
    }

    public Long adUpdate(Long id, AdUpdateRequestDto requestDto) {
        Ad ad = adRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 광고물이 없습니다. id = " + id));
        ad.update(requestDto.getTitle(), requestDto.getContent(), requestDto.getUrl(), requestDto.getImages());
        return id;
    }

    public AdResponseDto findById(Long id) {
        Ad entity = adRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 광고물이 없습니다. id = " + id));
        return new AdResponseDto(entity);
    }

    public Long ownerLogin(AdOwnerLoginRequestDto adOwnerLoginRequestDto) {
        AdOwner adOwner = adOwnerRepository.findByNickname(adOwnerLoginRequestDto.getNickname());
        return adOwner.getId();
    }
}
