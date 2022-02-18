package seoul.globalAdManagerPlatformByMtak.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class AdImg {
    @Id
    private String location;

    private Integer ad_id;

    @Builder
    public AdImg(String location, Integer ad_id) {
        this.location = location;
        this.ad_id = ad_id;
    }
}

