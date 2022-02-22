package seoul.globalAdManagerPlatformByMtak.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import seoul.globalAdManagerPlatformByMtak.domain.Ad;
import seoul.globalAdManagerPlatformByMtak.domain.AdImg;
import seoul.globalAdManagerPlatformByMtak.domain.AdOwner;
import seoul.globalAdManagerPlatformByMtak.domain.AdOwnerRepository;

import javax.persistence.Column;
import java.util.List;

@Getter
@NoArgsConstructor
public class AdSaveRequestDto {
    private String title;
    private String content;
    private String url;
    private String adOwner;
    private List<MultipartFile> images;

    @Autowired
    AdOwnerRepository adOwnerRepository;

    @Builder
    public AdSaveRequestDto(String title, String content, String url, String adOwner, List<MultipartFile> images) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.adOwner = adOwner;
        this.images = images;
    }

}
