package seoul.globalAdManagerPlatformByMtak.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdImg {
    @Id @GeneratedValue
    private Long id;
    @NotNull
    private Long boardIdx;
    @NotNull
    private String location;
    @NotNull
    private String fileName;

    private long fileSize;

    @ManyToOne
    @JoinColumn(name = "AD_ID")
    private Ad ad;

}

