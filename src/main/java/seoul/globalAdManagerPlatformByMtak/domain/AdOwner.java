package seoul.globalAdManagerPlatformByMtak.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class AdOwner {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nickname;

    @OneToMany(mappedBy = "owner")
    List<Ad> ads = new ArrayList<Ad>();

    @Builder
    public AdOwner(String nickname) {
        this.nickname = nickname;
    }
}
