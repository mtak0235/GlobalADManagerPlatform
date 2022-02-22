package seoul.globalAdManagerPlatformByMtak.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    @Column(length = 300)
    private String url;

    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private AdOwner owner;

    @OneToMany(mappedBy = "ad")
    private List<AdImg> images = new ArrayList<AdImg>();

    @Builder
    public Ad(String title, String content, String url, AdOwner owner) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.owner = owner;
    }

    public void setImages(List<AdImg> images) {
        this.images = images;
    }

    public void update(String title, String content, String url, List<AdImg> images) {
        this.title = title;
        this.content = content;
        this.url = url;
        this.images = images;
    }
}

