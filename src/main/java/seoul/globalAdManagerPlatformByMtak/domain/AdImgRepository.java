package seoul.globalAdManagerPlatformByMtak.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdImgRepository extends JpaRepository<AdImg, Long> {
    AdImg save(AdImg boardImg);
    List<AdImg> findAllByBoardIdx(Long boardIdx);
}
