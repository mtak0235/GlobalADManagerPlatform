package seoul.globalAdManagerPlatformByMtak.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import seoul.globalAdManagerPlatformByMtak.domain.AdOwner;

@Getter
@NoArgsConstructor
public class AdOwnerSaveRequestDto {

    private String nickname;

    @Builder
    public AdOwnerSaveRequestDto(String nickname) {
        this.nickname = nickname;
    }

    public AdOwner toEntity() {
        return AdOwner.builder()
                .nickname(nickname)
                .build();
    }
}
