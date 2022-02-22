package seoul.globalAdManagerPlatformByMtak.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AdOwnerLoginRequestDto {
    private String nickname;

    @Builder
    public AdOwnerLoginRequestDto(String nickname) {
        this.nickname = nickname;
    }
}
