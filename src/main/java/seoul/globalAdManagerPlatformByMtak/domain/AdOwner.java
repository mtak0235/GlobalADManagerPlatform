package seoul.globalAdManagerPlatformByMtak.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class AdOwner {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @Builder
    public AdOwner(String nickname) {
        this.nickname = nickname;
    }
}
