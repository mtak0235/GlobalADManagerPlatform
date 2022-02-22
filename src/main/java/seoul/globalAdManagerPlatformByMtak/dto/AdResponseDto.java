package seoul.globalAdManagerPlatformByMtak.dto;

import lombok.Builder;
import lombok.Getter;
import seoul.globalAdManagerPlatformByMtak.domain.Ad;
import seoul.globalAdManagerPlatformByMtak.domain.AdImg;
import seoul.globalAdManagerPlatformByMtak.domain.AdOwner;

import java.util.List;

@Getter
public class AdResponseDto {
    private Long id;
    private String title;
    private String content;
    private String url;
    private AdOwner owner;
    private List<AdImg> adImgs;

    @Builder
    public AdResponseDto(Ad entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.url = entity.getUrl();
        this.owner = entity.getOwner();
        this.adImgs = entity.getImages();
    }
}
