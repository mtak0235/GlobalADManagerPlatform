package seoul.globalAdManagerPlatformByMtak.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seoul.globalAdManagerPlatformByMtak.domain.AdImg;
import seoul.globalAdManagerPlatformByMtak.domain.AdOwner;

import java.util.List;

@Getter
@NoArgsConstructor
public class AdUpdateRequestDto {
    private String title;
    private String content;
    private String url;
    private List<AdImg> images;
    private AdOwner adOwner;

    @Builder
    public AdUpdateRequestDto(String title, String content, String url, List<AdImg> images, AdOwner adOwner) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.images = images;
        this.adOwner = adOwner;
    }
}
