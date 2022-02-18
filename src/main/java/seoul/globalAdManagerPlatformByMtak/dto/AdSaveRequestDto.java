package seoul.globalAdManagerPlatformByMtak.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seoul.globalAdManagerPlatformByMtak.domain.Ad;

import javax.persistence.Column;

@Getter
@NoArgsConstructor
public class AdSaveRequestDto {
    private String title;
    private String content;
    private String url;
    private Integer owner_id;

    @Builder
    public AdSaveRequestDto(String title, String content, String url, Integer owner_id) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.owner_id = owner_id;
    }

    public Ad toEntity() {
        return Ad.builder()
                .title(title)
                .content(content)
                .url(url)
                .owner_id(owner_id)
                .build();
    }
}
